package org.support.project.web.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.support.project.aop.Aspect;
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
    
    /**
     * 古いデータを物理削除
     * @return 削除件数
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public int physicalDeleteOnOldData() {
        String sql = "DELETE FROM MAILS WHERE INSERT_DATETIME < ? AND (STATUS >= 100 OR DELETE_FLAG = 1);";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -10); // 10日より前は消す対象
        Timestamp t = new Timestamp(calendar.getTimeInMillis());
        return executeUpdate(sql, t);
    }

}
