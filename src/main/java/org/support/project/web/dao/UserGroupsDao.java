package org.support.project.web.dao;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.dao.gen.GenUserGroupsDao;

/**
 * ユーザが所属するグループ
 */
@DI(instance = Instance.Singleton)
public class UserGroupsDao extends GenUserGroupsDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * インスタンス取得 AOPに対応
     * 
     * @return インスタンス
     */
    public static UserGroupsDao get() {
        return Container.getComp(UserGroupsDao.class);
    }

}
