package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.ReadMarksEntity;
import org.support.project.ormapping.dao.AbstractDao;
import org.support.project.ormapping.exception.ORMappingException;
import org.support.project.ormapping.common.SQLManager;
import org.support.project.ormapping.common.DBUserPool;
import org.support.project.ormapping.common.IDGen;
import org.support.project.ormapping.config.ORMappingParameter;
import org.support.project.ormapping.connection.ConnectionManager;
import org.support.project.common.util.PropertyUtil;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.aop.Aspect;

/**
 * 既読
 * this class is auto generate and not edit.
 * if modify dao method, you can edit ReadMarksDao.
 */
@DI(instance = Instance.Singleton)
public class GenReadMarksDao extends AbstractDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * Get instance from DI container.
     * @return instance
     */
    public static GenReadMarksDao get() {
        return Container.getComp(GenReadMarksDao.class);
    }

    /**
     * Select all data.
     * @return all data
     */
    public List<ReadMarksEntity> physicalSelectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_physical_select_all.sql");
        return executeQueryList(sql, ReadMarksEntity.class);
    }
    /**
     * Select all data with pager.
     * @param limit limit
     * @param offset offset
     * @return all data on limit and offset
     */
    public List<ReadMarksEntity> physicalSelectAllWithPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_physical_select_all_with_pager.sql");
        return executeQueryList(sql, ReadMarksEntity.class, limit, offset);
    }
    /**
     * Select data on key.
     * @param  no no
     * @param  userId userId
     * @return data
     */
    public ReadMarksEntity physicalSelectOnKey(Integer no, Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_physical_select_on_key.sql");
        return executeQuerySingle(sql, ReadMarksEntity.class, no, userId);
    }
    /**
     * Select all data that not deleted.
     * @return all data
     */
    public List<ReadMarksEntity> selectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_select_all.sql");
        return executeQueryList(sql, ReadMarksEntity.class);
    }
    /**
     * Select all data that not deleted with pager.
     * @param limit limit
     * @param offset offset
     * @return all data
     */
    public List<ReadMarksEntity> selectAllWidthPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_select_all_with_pager.sql");
        return executeQueryList(sql, ReadMarksEntity.class, limit, offset);
    }
    /**
     * Select count that not deleted.
     * @return count
     */
    public Integer selectCountAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_select_count_all.sql");
        return executeQuerySingle(sql, Integer.class);
    }
    /**
     * Select data that not deleted on key.
     * @param  no no
     * @param  userId userId
     * @return data
     */
    public ReadMarksEntity selectOnKey(Integer no, Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_select_on_key.sql");
        return executeQuerySingle(sql, ReadMarksEntity.class, no, userId);
    }
    /**
     * Select data that not deleted on NO column.
     * @param no no
     * @return list
     */
    public List<ReadMarksEntity> selectOnNo(Integer no) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_select_on_no.sql");
        return executeQueryList(sql, ReadMarksEntity.class, no);
    }
    /**
     * Select data that not deleted on USER_ID column.
     * @param userId userId
     * @return list
     */
    public List<ReadMarksEntity> selectOnUserId(Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_select_on_user_id.sql");
        return executeQueryList(sql, ReadMarksEntity.class, userId);
    }
    /**
     * Select data on NO column.
     * @param no no
     * @return list
     */
    public List<ReadMarksEntity> physicalSelectOnNo(Integer no) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_physical_select_on_no.sql");
        return executeQueryList(sql, ReadMarksEntity.class, no);
    }
    /**
     * Select data on USER_ID column.
     * @param userId userId
     * @return list
     */
    public List<ReadMarksEntity> physicalSelectOnUserId(Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_physical_select_on_user_id.sql");
        return executeQueryList(sql, ReadMarksEntity.class, userId);
    }
    /**
     * Create row id.
     * @return row id
     */
    protected String createRowId() {
        return IDGen.get().gen("READ_MARKS");
    }
    /**
     * Physical Insert.
     * it is not create key on database sequence.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity rawPhysicalInsert(ReadMarksEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_raw_insert.sql");
        executeUpdate(sql, 
            entity.getNo(), 
            entity.getUserId(), 
            entity.getShowNextTime(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag());
        return entity;
    }
    /**
     * Physical Insert.
     * if key column have sequence, key value create by database.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity physicalInsert(ReadMarksEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_insert.sql");
        executeUpdate(sql, 
            entity.getNo(), 
            entity.getUserId(), 
            entity.getShowNextTime(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag());
        return entity;
    }
    /**
     * Insert.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity insert(Integer user, ReadMarksEntity entity) {
        entity.setInsertUser(user);
        entity.setInsertDatetime(new Timestamp(new java.util.Date().getTime()));
        entity.setUpdateUser(user);
        entity.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        entity.setDeleteFlag(0);
        entity.setRowId(createRowId());
        return physicalInsert(entity);
    }
    /**
     * Insert.
     * saved user id is auto set.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity insert(ReadMarksEntity entity) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer userId = (Integer) pool.getUser();
        return insert(userId, entity);
    }
    /**
     * Physical Update.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity physicalUpdate(ReadMarksEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_update.sql");
        executeUpdate(sql, 
            entity.getShowNextTime(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag(), 
            entity.getNo(), 
            entity.getUserId());
        return entity;
    }
    /**
     * Update.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity update(Integer user, ReadMarksEntity entity) {
        ReadMarksEntity db = selectOnKey(entity.getNo(), entity.getUserId());
        entity.setInsertUser(db.getInsertUser());
        entity.setInsertDatetime(db.getInsertDatetime());
        entity.setDeleteFlag(db.getDeleteFlag());
        entity.setUpdateUser(user);
        entity.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        return physicalUpdate(entity);
    }
    /**
     * Update.
     * saved user id is auto set.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity update(ReadMarksEntity entity) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer userId = (Integer) pool.getUser();
        return update(userId, entity);
    }
    /**
     * Save. 
     * if same key data is exists, the data is update. otherwise the data is insert.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity save(Integer user, ReadMarksEntity entity) {
        ReadMarksEntity db = selectOnKey(entity.getNo(), entity.getUserId());
        if (db == null) {
            return insert(user, entity);
        } else {
            return update(user, entity);
        }
    }
    /**
     * Save. 
     * if same key data is exists, the data is update. otherwise the data is insert.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public ReadMarksEntity save(ReadMarksEntity entity) {
        ReadMarksEntity db = selectOnKey(entity.getNo(), entity.getUserId());
        if (db == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }
    /**
     * Physical Delete.
     * @param  no no
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(Integer no, Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ReadMarksDao/ReadMarksDao_delete.sql");
        executeUpdate(sql, no, userId);
    }
    /**
     * Physical Delete.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(ReadMarksEntity entity) {
        physicalDelete(entity.getNo(), entity.getUserId());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param  no no
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, Integer no, Integer userId) {
        ReadMarksEntity db = selectOnKey(no, userId);
        db.setDeleteFlag(1);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * @param  no no
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer no, Integer userId) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        delete(user, no, userId);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, ReadMarksEntity entity) {
        delete(user, entity.getNo(), entity.getUserId());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(ReadMarksEntity entity) {
        delete(entity.getNo(), entity.getUserId());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param  no no
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, Integer no, Integer userId) {
        ReadMarksEntity db = physicalSelectOnKey(no, userId);
        db.setDeleteFlag(0);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param  no no
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer no, Integer userId) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        activation(user, no, userId);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, ReadMarksEntity entity) {
        activation(user, entity.getNo(), entity.getUserId());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(ReadMarksEntity entity) {
        activation(entity.getNo(), entity.getUserId());

    }

}
