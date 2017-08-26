package org.support.project.web.dao;

import java.util.List;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.dao.gen.GenMailsDao;
import org.support.project.web.entity.MailsEntity;

/**
 * メール
 */
@DI(instance = Instance.Singleton)
public class MailsDao extends GenMailsDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * インスタンス取得 AOPに対応
     * 
     * @return インスタンス
     */
    public static MailsDao get() {
        return Container.getComp(MailsDao.class);
    }

    /**
     * ステータスで取得
     * 
     * @param status status
     * @return mail list
     */
    public List<MailsEntity> selectOnStatus(int status) {
        String sql = "SELECT * FROM MAILS WHERE STATUS < ? AND DELETE_FLAG = 0 ORDER BY INSERT_DATETIME";
        return executeQueryList(sql, MailsEntity.class, status);
    }

}
