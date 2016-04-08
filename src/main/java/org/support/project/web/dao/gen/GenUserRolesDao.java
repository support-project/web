package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.UserRolesEntity;
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
 * ユーザの権限
 * this class is auto generate and not edit.
 * if modify dao method, you can edit UserRolesDao.
 */
@DI(instance = Instance.Singleton)
public class GenUserRolesDao extends AbstractDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * Get instance from DI container.
     * @return instance
     */
    public static GenUserRolesDao get() {
        return Container.getComp(GenUserRolesDao.class);
    }

    /**
     * Select all data.
     * @return all data
     */
    public List<UserRolesEntity> physicalSelectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_all.sql");
        return executeQueryList(sql, UserRolesEntity.class);
    }
    /**
     * Select all data with pager.
     * @param limit limit
     * @param offset offset
     * @return all data on limit and offset
     */
    public List<UserRolesEntity> physicalSelectAllWithPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_all_with_pager.sql");
        return executeQueryList(sql, UserRolesEntity.class, limit, offset);
    }
    /**
     * Select data on key.
     * @param  roleId roleId
     * @param  userId userId
     * @return data
     */
    public UserRolesEntity physicalSelectOnKey(Integer roleId, Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_on_key.sql");
        return executeQuerySingle(sql, UserRolesEntity.class, roleId, userId);
    }
    /**
     * Select all data that not deleted.
     * @return all data
     */
    public List<UserRolesEntity> selectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_all.sql");
        return executeQueryList(sql, UserRolesEntity.class);
    }
    /**
     * Select all data that not deleted with pager.
     * @param limit limit
     * @param offset offset
     * @return all data
     */
    public List<UserRolesEntity> selectAllWidthPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_all_with_pager.sql");
        return executeQueryList(sql, UserRolesEntity.class, limit, offset);
    }
    /**
     * Select data that not deleted on key.
     * @param  roleId roleId
     * @param  userId userId
     * @return data
     */
    public UserRolesEntity selectOnKey(Integer roleId, Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_on_key.sql");
        return executeQuerySingle(sql, UserRolesEntity.class, roleId, userId);
    }
    /**
     * Select data that not deleted on ROLE_ID column.
     * @param roleId roleId
     * @return list
     */
    public List<UserRolesEntity> selectOnRoleId(Integer roleId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_on_role_id.sql");
        return executeQueryList(sql, UserRolesEntity.class, roleId);
    }
    /**
     * Select data that not deleted on USER_ID column.
     * @param userId userId
     * @return list
     */
    public List<UserRolesEntity> selectOnUserId(Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_on_user_id.sql");
        return executeQueryList(sql, UserRolesEntity.class, userId);
    }
    /**
     * Select data on ROLE_ID column.
     * @param roleId roleId
     * @return list
     */
    public List<UserRolesEntity> physicalSelectOnRoleId(Integer roleId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_on_role_id.sql");
        return executeQueryList(sql, UserRolesEntity.class, roleId);
    }
    /**
     * Select data on USER_ID column.
     * @param userId userId
     * @return list
     */
    public List<UserRolesEntity> physicalSelectOnUserId(Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_on_user_id.sql");
        return executeQueryList(sql, UserRolesEntity.class, userId);
    }
    /**
     * Create row id.
     * @return row id
     */
    protected String createRowId() {
        return IDGen.get().gen("USER_ROLES");
    }
    /**
     * Physical Insert.
     * it is not create key on database sequence.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public UserRolesEntity rawPhysicalInsert(UserRolesEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_raw_insert.sql");
        executeUpdate(sql, 
            entity.getRoleId(), 
            entity.getUserId(), 
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
    public UserRolesEntity physicalInsert(UserRolesEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_insert.sql");
        executeUpdate(sql, 
            entity.getRoleId(), 
            entity.getUserId(), 
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
    public UserRolesEntity insert(Integer user, UserRolesEntity entity) {
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
    public UserRolesEntity insert(UserRolesEntity entity) {
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
    public UserRolesEntity physicalUpdate(UserRolesEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_update.sql");
        executeUpdate(sql, 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag(), 
            entity.getRoleId(), 
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
    public UserRolesEntity update(Integer user, UserRolesEntity entity) {
        UserRolesEntity db = selectOnKey(entity.getRoleId(), entity.getUserId());
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
    public UserRolesEntity update(UserRolesEntity entity) {
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
    public UserRolesEntity save(Integer user, UserRolesEntity entity) {
        UserRolesEntity db = selectOnKey(entity.getRoleId(), entity.getUserId());
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
    public UserRolesEntity save(UserRolesEntity entity) {
        UserRolesEntity db = selectOnKey(entity.getRoleId(), entity.getUserId());
        if (db == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }
    /**
     * Physical Delete.
     * @param  roleId roleId
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(Integer roleId, Integer userId) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_delete.sql");
        executeUpdate(sql, roleId, userId);
    }
    /**
     * Physical Delete.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(UserRolesEntity entity) {
        physicalDelete(entity.getRoleId(), entity.getUserId());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param  roleId roleId
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, Integer roleId, Integer userId) {
        UserRolesEntity db = selectOnKey(roleId, userId);
        db.setDeleteFlag(1);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * @param  roleId roleId
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer roleId, Integer userId) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        delete(user, roleId, userId);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, UserRolesEntity entity) {
        delete(user, entity.getRoleId(), entity.getUserId());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(UserRolesEntity entity) {
        delete(entity.getRoleId(), entity.getUserId());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param  roleId roleId
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, Integer roleId, Integer userId) {
        UserRolesEntity db = physicalSelectOnKey(roleId, userId);
        db.setDeleteFlag(0);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param  roleId roleId
     * @param  userId userId
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer roleId, Integer userId) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        activation(user, roleId, userId);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, UserRolesEntity entity) {
        activation(user, entity.getRoleId(), entity.getUserId());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(UserRolesEntity entity) {
        activation(entity.getRoleId(), entity.getUserId());

    }

}
