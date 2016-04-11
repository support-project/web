package org.support.project.web.logic;

import java.util.List;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.dao.NoticesDao;
import org.support.project.web.entity.NoticesEntity;

@DI(instance = Instance.Singleton)
public class NoticesLogic {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(NoticesLogic.class);
    /**
     * Get instance
     * @return instance
     */
    public static NoticesLogic get() {
        return Container.getComp(NoticesLogic.class);
    }
    
    public List<NoticesEntity> selectAllNotices(Integer limit, Integer offset) {
        return NoticesDao.get().selectAllWidthPager(limit, offset);
    }
    public NoticesEntity selectNotice(Integer no) {
        return NoticesDao.get().selectOnKey(no);
    }
    
    public NoticesEntity insertNotice(NoticesEntity entity) {
        LOG.trace("insertNotice");
        return NoticesDao.get().insert(entity);
    }
    public NoticesEntity updateNotice(NoticesEntity entity) {
        LOG.trace("updateNotice");
        NoticesEntity exists = NoticesDao.get().selectOnKey(entity.getNo());
        if (exists == null) {
            return null;
        }
        return NoticesDao.get().update(entity);
    }

}
