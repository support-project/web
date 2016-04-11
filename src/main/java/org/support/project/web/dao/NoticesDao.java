package org.support.project.web.dao;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;

import org.support.project.web.dao.gen.GenNoticesDao;

/**
 * 告知
 */
@DI(instance = Instance.Singleton)
public class NoticesDao extends GenNoticesDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;
    /**
     * Get instance from DI container.
     * @return instance
     */
    public static NoticesDao get() {
        return Container.getComp(NoticesDao.class);
    }


    /**
     * ID 
     */
    private int currentId = 0;

    /**
     * IDを採番 
     * ※コミットしなくても次のIDを採番する為、保存しなければ欠番になる 
     */
    public Integer getNextId() {
        String sql = "SELECT MAX(NO) FROM NOTICES;";
        Integer integer = executeQuerySingle(sql, Integer.class);
        if (integer != null) {
            if (currentId < integer) {
                currentId = integer;
            }
        }
        currentId++;
        return currentId;
    }


}
