package org.support.project.web.logic.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.directory.api.ldap.model.exception.LdapException;
import org.support.project.common.config.ConfigLoader;
import org.support.project.common.config.INT_FLAG;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.PasswordUtil;
import org.support.project.common.util.RandomUtil;
import org.support.project.common.util.StringUtils;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.bean.LdapInfo;
import org.support.project.web.bean.LoginedUser;
import org.support.project.web.config.AppConfig;
import org.support.project.web.config.WebConfig;
import org.support.project.web.dao.LdapConfigsDao;
import org.support.project.web.dao.UsersDao;
import org.support.project.web.entity.LdapConfigsEntity;
import org.support.project.web.entity.UsersEntity;
import org.support.project.web.exception.AuthenticateException;
import org.support.project.web.logic.AddUserProcess;
import org.support.project.web.logic.LdapLogic;
import org.support.project.web.logic.UserLogic;

@DI(instance = Instance.Singleton)
public class DefaultAuthenticationLogicImpl extends AbstractAuthenticationLogic<LoginedUser> {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(DefaultAuthenticationLogicImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.support.project.web.logic.impl.AbstractAuthenticationLogic#auth(java.lang.String, java.lang.String)
     */
    @Override
    public boolean auth(String userId, String password) throws AuthenticateException {
        initLogic();
        // Ldap認証が有効であれば、Ldap認証を実施する
        LdapConfigsDao dao = LdapConfigsDao.get();
        LdapConfigsEntity entity = dao.selectOnKey(AppConfig.get().getSystemName());
        if (entity != null && entity.getAuthType() != null) {
            try {
                if (entity.isLdapLoginAble()) {
                    LdapLogic ldapLogic = LdapLogic.get();
                    LdapInfo ldapInfo = ldapLogic.auth(entity, userId, password);
                    if (ldapInfo == null && entity.isLdapLoginOnly()) {
                        // 認証タイプがLdapのみの場合、Ldap認証に失敗したら処理終了
                        return false;
                    }
                    if (ldapInfo != null) {
                        // Ldap認証成功
                        UsersDao usersDao = UsersDao.get();
                        UsersEntity usersEntity = usersDao.selectOnLowerUserKey(userId);
                        if (usersEntity == null) {
                            usersEntity = addUser(userId, password, ldapInfo);
                            // 拡張処理の呼び出し
                            if (StringUtils.isNotEmpty(AppConfig.get().getAddUserProcess())) {
                                AddUserProcess process = Container.getComp(AppConfig.get().getAddUserProcess(), AddUserProcess.class);
                                process.addUserProcess(usersEntity.getUserKey());
                            }
                        } else {
                            updateUser(userId, password, ldapInfo, usersDao, usersEntity);
                        }
                        return true;
                    }
                }
            } catch (LdapException | IOException e) {
                throw new AuthenticateException(e);
            }
        }
        // DB認証開始
        try {
            UsersDao usersDao = UsersDao.get();
            UsersEntity usersEntity = usersDao.selectOnUserKey(userId);

            AppConfig config = ConfigLoader.load(AppConfig.APP_CONFIG, AppConfig.class);
            if (usersEntity != null) {
                String hash = PasswordUtil.getStretchedPassword(password, usersEntity.getSalt(), config.getHashIterations());
                if (usersEntity.getPassword().equals(hash)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new AuthenticateException(e);
        }
    }

    /**
     * Ldapから取得した情報でユーザ情報更新 同一IDの
     * 
     * @param userId
     * @param ldapInfo
     * @param usersDao
     * @param usersEntity
     */
    private void updateUser(String userId, String password, LdapInfo ldapInfo, UsersDao usersDao, UsersEntity usersEntity) {
        // 既にユーザ情報は登録されているので、Ldapの情報でデータ更新があればKnowledgeのユーザ情報を更新する
        boolean change = false;
        if (StringUtils.isNotEmpty(ldapInfo.getName())) {
            if (!ldapInfo.getName().equals(usersEntity.getUserName())) {
                usersEntity.setUserName(ldapInfo.getName());
                change = true;
            }
        }
        if (StringUtils.isNotEmpty(ldapInfo.getMail())) {
            if (StringUtils.isEmailAddress(ldapInfo.getMail()) && !ldapInfo.getMail().equals(usersEntity.getMailAddress())) {
                usersEntity.setMailAddress(ldapInfo.getMail());
                change = true;
            }
        }
        if (usersEntity.getAuthLdap() == null || usersEntity.getAuthLdap().intValue() != INT_FLAG.ON.getValue()) {
            // 既にKnowledgeに登録されているユーザとLdapのユーザのIDが同じ場合は、
            // 既存のユーザ情報を更新する？？？
            // TODO 更新で良いか、検討する必要あり（いったん更新する）
            usersEntity.setAuthLdap(INT_FLAG.ON.getValue());
            change = true;
        }
        if (change) {
            usersDao.save(usersEntity);
            LOG.debug("Change User info on Ldap login. [user]" + userId);
        }
    }

    /**
     * Ldapから取得した情報でユーザ登録
     * 
     * @param userId
     * @param password
     * @param ldapInfo
     */
    private UsersEntity addUser(String userId, String password, LdapInfo ldapInfo) {
        UsersEntity usersEntity;
        // Ldap認証でユーザ登録されていないユーザがログイン
        usersEntity = new UsersEntity();
        usersEntity.setUserKey(ldapInfo.getId());
        if (StringUtils.isNotEmpty(ldapInfo.getName())) {
            usersEntity.setUserName(ldapInfo.getName());
        } else {
            usersEntity.setUserName(ldapInfo.getId());
        }
        if (StringUtils.isNotEmpty(ldapInfo.getMail())) {
            if (StringUtils.isEmailAddress(ldapInfo.getMail())) {
                usersEntity.setMailAddress(ldapInfo.getMail());
            }
        }
        usersEntity.setAuthLdap(INT_FLAG.ON.getValue());
        usersEntity.setAdmin(ldapInfo.isAdmin());
        // usersEntity.setPassword(password);
        usersEntity.setPassword(RandomUtil.randamGen(24)); // Ldapログインしたユーザのパスワードは推測不可能な形にしておく

        List<String> roles = new ArrayList<String>();
        roles.add(WebConfig.ROLE_USER);
        if (ldapInfo.isAdmin()) {
            roles.add(WebConfig.ROLE_ADMIN);
        }
        usersEntity = UserLogic.get().insert(usersEntity, roles.toArray(new String[0]));
        LOG.info("Add User on first Ldap login. [user]" + userId);
        return usersEntity;
    }

}
