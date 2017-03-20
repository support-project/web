package org.support.project.web.logic;

import java.util.ArrayList;
import java.util.List;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.dao.NotificationsDao;
import org.support.project.web.dao.UserNotificationsDao;
import org.support.project.web.dao.UsersDao;
import org.support.project.web.entity.NotificationsEntity;
import org.support.project.web.entity.UserNotificationsEntity;
import org.support.project.web.entity.UsersEntity;

@DI(instance = Instance.Singleton)
public class NotificationLogic {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(NotificationLogic.class);
    /** 通知ステータス : 未読 */
    public static final int STATUS_UNREAD = 0;
    /** 通知ステータス : 既読 */
    public static final int STATUS_READED = 1;
    
    /**
     * Get instance
     * @return instance
     */
    public static NotificationLogic get() {
        return Container.getComp(NotificationLogic.class);
    }
    
    /**
     * 指定のロールのユーザに通知を登録
     * @param title タイトル
     * @param content 内容
     * @param roles ロール
     */
    public void addNotify(String title, String content, String... roles) {
        NotificationsEntity notification = new NotificationsEntity();
        notification.setTitle(title);
        notification.setContent(content);
        notification = NotificationsDao.get().insert(notification);
        LOG.info("Add notification [No] " + notification.getNo());
        
        List<Integer> userList = new ArrayList<>();
        for (String role : roles) {
            List<UsersEntity> users = UsersDao.get().selectOnRoleKey(role);
            for (UsersEntity usersEntity : users) {
                if (!userList.contains(usersEntity.getUserId())) {
                    UserNotificationsEntity userNotification = new UserNotificationsEntity(notification.getNo(), usersEntity.getUserId());
                    userNotification.setStatus(STATUS_UNREAD);
                    UserNotificationsDao.get().insert(userNotification);
                    LOG.info("Add notification [No] " + notification.getNo() + " [User] " + usersEntity.getUserId());
                    userList.add(usersEntity.getUserId());
                }
            }
        }
    }
    
    /**
     * 指定のユーザの通知の件数を取得
     * @param loginUserId ログインユーザID
     * @return 件数
     */
    public int count(Integer loginUserId) {
        return UserNotificationsDao.get().count(loginUserId);
    }
    /**
     * 指定のユーザの未読の件数を取得
     * @param loginUserId ログインユーザID
     * @return 件数
     */
    public int countUnRead(Integer loginUserId) {
        return UserNotificationsDao.get().countOnStatus(loginUserId, STATUS_UNREAD);
    }
    
    /**
     * 指定のユーザの通知の取得
     * @param loginUserId ログインユーザID
     * @param offset ページオフセット
     * @return 通知
     */
    public List<NotificationsEntity> getNotification(Integer loginUserId, int offset) {
        int limit = 50;
        offset = limit * offset;
        return UserNotificationsDao.get().selectOnUser(loginUserId, limit, offset);
    }
    
    /**
     * 通知の既読状態を更新
     * @param loginUserId ログインユーザID
     * @param no 通知番号
     * @param status ステータス
     * @return 更新結果
     */
    public boolean setStatus(Integer loginUserId, long no, int status) {
        UserNotificationsEntity entity = UserNotificationsDao.get().selectOnKey(no, loginUserId);
        if (entity == null) {
            return false;
        }
        entity.setStatus(status);
        UserNotificationsDao.get().update(entity);
        return true;
    }

}
