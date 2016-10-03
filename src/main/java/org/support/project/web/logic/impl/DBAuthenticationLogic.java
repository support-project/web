package org.support.project.web.logic.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.support.project.common.exception.SystemException;
import org.support.project.di.Container;
import org.support.project.web.bean.LoginedUser;
import org.support.project.web.bean.User;
import org.support.project.web.config.CommonWebParameter;
import org.support.project.web.dao.ManageFunctionDao;
import org.support.project.web.dao.ManageUserDao;
import org.support.project.web.exception.AuthenticateException;
import org.support.project.web.logic.AuthenticationLogic;

public class DBAuthenticationLogic implements AuthenticationLogic<LoginedUser> {

    private ManageUserDao dao;
    private ManageFunctionDao functionDao;

    private Map<String, List<String>> functionAccessMap;

    public DBAuthenticationLogic() {
        dao = Container.getComp(ManageUserDao.class);
        functionDao = Container.getComp(ManageFunctionDao.class);
        functionAccessMap = new HashMap<>();
    }

    @Override
    public boolean isAuthorize(HttpServletRequest request) {
        String function = request.getServletPath();

        if (!functionAccessMap.containsKey(function)) {
            try {
                List<String> accessRoleIds = functionDao.getAccessRoleIds(function);
                functionAccessMap.put(function, accessRoleIds);
            } catch (SQLException e) {
                throw new AuthenticateException(e);
            }
        }

        List<String> accessRoleIds = functionAccessMap.get(function);
        if (accessRoleIds == null || accessRoleIds.isEmpty()) {
            return true;
        } else {
            List<String> userRoles = getLoginRoleIds(request);
            for (String accessRole : accessRoleIds) {
                for (String userRole : userRoles) {
                    if (accessRole.equals(userRole)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // @Override
    public String encryptionPassword(String password) {
        AuthParamManager manager = Container.getComp(AuthParamManager.class);
        AuthParam param = manager.getParam();

        MessageDigest md;
        try {
            md = MessageDigest.getInstance(param.getPasswordEncType()); // あるいはMD5など→アルゴリズム名
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        System.out.println(md.getAlgorithm());

        md.update(password.getBytes());
        byte[] bytes = md.digest();

        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(Integer.toHexString(b));
        }
        return builder.toString().toUpperCase();
    }

    @Override
    public boolean isLogined(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(CommonWebParameter.LOGIN_USER_ID_SESSION_KEY) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void setSession(String userId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(CommonWebParameter.LOGIN_USER_ID_SESSION_KEY, userId);

        // ロールを取得しセッションにセット
        try {
            List<String> roleIds = dao.getRoles(userId);
            session.setAttribute(CommonWebParameter.LOGIN_ROLE_IDS_SESSION_KEY, roleIds);
        } catch (SQLException e) {
            throw new AuthenticateException(e);
        }
    }

    @Override
    public LoginedUser getSession(HttpServletRequest request) throws AuthenticateException {
        return null;
    }

    @Override
    public void clearSession(HttpServletRequest request) throws AuthenticateException {
    }

    // @Override
    public String getLoginUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute(CommonWebParameter.LOGIN_USER_ID_SESSION_KEY);
    }

    // @Override
    public List<String> getLoginRoleIds(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (List<String>) session.getAttribute(CommonWebParameter.LOGIN_ROLE_IDS_SESSION_KEY);
    }

    @Override
    public boolean auth(String userId, String password) {
        User user;
        try {
            user = dao.getUser(userId);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        if (user != null) {
            String encPass = encryptionPassword(password);
            if (encPass.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    // @Override
    public int insertUser(String userId, String password, String userName, String performer, Map<String, Object> params, String... roleIds) {
        try {
            String encPass = encryptionPassword(password);
            return dao.insertUser(userId, encPass, userName, performer, roleIds);
        } catch (SQLException e) {
            throw new AuthenticateException(e);
        }
    }

    // @Override
    public int updateUser(String userId, String password, String userName, String performer, Map<String, Object> params, String... roleIds) {
        try {
            String encPass = encryptionPassword(password);
            return dao.updateUser(userId, encPass, userName, performer, roleIds);
        } catch (SQLException e) {
            throw new AuthenticateException(e);
        }
    }

    // @Override
    public int deleteUser(String userId, String performer) {
        try {
            return dao.deleteUser(userId, performer);
        } catch (SQLException e) {
            throw new AuthenticateException(e);
        }
    }

    // @Override
    public User getUser(String userId) throws SystemException {
        try {
            return dao.getUser(userId);
        } catch (SQLException e) {
            throw new AuthenticateException(e);
        }
    }

    // @Override
    public List<User> listUsers() throws SystemException {
        try {
            return dao.listUsers();
        } catch (SQLException e) {
            throw new AuthenticateException(e);
        }
    }

    @Override
    public void setCookie(HttpServletRequest req, HttpServletResponse res) throws AuthenticateException {
        // Auto-generated method stub
    }

    @Override
    public boolean cookieLogin(HttpServletRequest req, HttpServletResponse res) throws AuthenticateException {
        // Auto-generated method stub
        return false;
    }

    @Override
    public void initCookie(int cookieMaxAge, String cookieEncryptKey, boolean cookieSecure) {
        // Auto-generated method stub
        
    }

}
