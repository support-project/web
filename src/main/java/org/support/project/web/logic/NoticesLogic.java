package org.support.project.web.logic;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.bean.SendList;
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
    
    public SendList selectAllNotices(Integer limit, Integer offset) {
        SendList sendList = new SendList();
        sendList.setLimit(limit);
        sendList.setOffset(offset);
        sendList.setItems(NoticesDao.get().selectAllWidthPager(limit, offset));
        sendList.setTotal(NoticesDao.get().selectCountAll());
        return sendList;
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

    public NoticesEntity deleteNotice(Integer no) {
        LOG.trace("deleteNotice");
        NoticesEntity exists = NoticesDao.get().selectOnKey(no);
        if (exists == null) {
            return null;
        }
        NoticesDao.get().delete(no);
        return exists;
    }

}
