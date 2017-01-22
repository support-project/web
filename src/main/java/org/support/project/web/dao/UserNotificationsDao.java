package org.support.project.web.dao;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;

import org.support.project.web.dao.gen.GenUserNotificationsDao;

/**
 * ユーザへの通知
 */
@DI(instance = Instance.Singleton)
public class UserNotificationsDao extends GenUserNotificationsDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;
    /**
     * Get instance from DI container.
     * @return instance
     */
    public static UserNotificationsDao get() {
        return Container.getComp(UserNotificationsDao.class);
    }



}
