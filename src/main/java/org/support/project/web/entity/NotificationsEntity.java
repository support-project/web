package org.support.project.web.entity;

import org.support.project.web.entity.gen.GenNotificationsEntity;

import java.util.List;
import java.util.Map;

import org.support.project.common.bean.ValidateError;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;

import java.sql.Timestamp;


/**
 * 通知
 */
@DI(instance = Instance.Prototype)
public class NotificationsEntity extends GenNotificationsEntity {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * Get instance from DI container.
     * @return instance
     */
    public static NotificationsEntity get() {
        return Container.getComp(NotificationsEntity.class);
    }

    /**
     * Constructor.
     */
    public NotificationsEntity() {
        super();
    }

    /**
     * Constructor
     * @param no NO
     */

    public NotificationsEntity(Long no) {
        super( no);
    }

}
