package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.SystemConfigsEntity;
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
 * コンフィグ
 * this class is auto generate and not edit.
 * if modify dao method, you can edit SystemConfigsDao.
 */
@DI(instance = Instance.Singleton)
public class GenSystemConfigsDao extends AbstractDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * Get instance from DI container.
     * @return instance
     */
    public static GenSystemConfigsDao get() {
        return Container.getComp(GenSystemConfigsDao.class);
    }

    /**
     * Select all data.
     * @return all data
     */
    public List<SystemConfigsEntity> physicalSelectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_all.sql");
        return executeQueryList(sql, SystemConfigsEntity.class);
    }
    /**
     * Select all data with pager.
     * @param limit limit
     * @param offset offset
     * @return all data on limit and offset
     */
    public List<SystemConfigsEntity> physicalSelectAllWithPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_all_with_pager.sql");
        return executeQueryList(sql, SystemConfigsEntity.class, limit, offset);
    }
    /**
     * Select data on key.
     * @param  configName configName
     * @param  systemName systemName
     * @return data
     */
    public SystemConfigsEntity physicalSelectOnKey(String configName, String systemName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_on_key.sql");
        return executeQuerySingle(sql, SystemConfigsEntity.class, configName, systemName);
    }
    /**
     * Select all data that not deleted.
     * @return all data
     */
    public List<SystemConfigsEntity> selectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_all.sql");
        return executeQueryList(sql, SystemConfigsEntity.class);
    }
    /**
     * Select all data that not deleted with pager.
     * @param limit limit
     * @param offset offset
     * @return all data
     */
    public List<SystemConfigsEntity> selectAllWidthPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_all_with_pager.sql");
        return executeQueryList(sql, SystemConfigsEntity.class, limit, offset);
    }
    /**
     * Select count that not deleted.
     * @return count
     */
    public Integer selectCountAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_count_all.sql");
        return executeQuerySingle(sql, Integer.class);
    }
    /**
     * Select data that not deleted on key.
     * @param  configName configName
     * @param  systemName systemName
     * @return data
     */
    public SystemConfigsEntity selectOnKey(String configName, String systemName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_on_key.sql");
        return executeQuerySingle(sql, SystemConfigsEntity.class, configName, systemName);
    }
    /**
     * Select data that not deleted on CONFIG_NAME column.
     * @param configName configName
     * @return list
     */
    public List<SystemConfigsEntity> selectOnConfigName(String configName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_on_config_name.sql");
        return executeQueryList(sql, SystemConfigsEntity.class, configName);
    }
    /**
     * Select data that not deleted on SYSTEM_NAME column.
     * @param systemName systemName
     * @return list
     */
    public List<SystemConfigsEntity> selectOnSystemName(String systemName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_on_system_name.sql");
        return executeQueryList(sql, SystemConfigsEntity.class, systemName);
    }
    /**
     * Select data on CONFIG_NAME column.
     * @param configName configName
     * @return list
     */
    public List<SystemConfigsEntity> physicalSelectOnConfigName(String configName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_on_config_name.sql");
        return executeQueryList(sql, SystemConfigsEntity.class, configName);
    }
    /**
     * Select data on SYSTEM_NAME column.
     * @param systemName systemName
     * @return list
     */
    public List<SystemConfigsEntity> physicalSelectOnSystemName(String systemName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_on_system_name.sql");
        return executeQueryList(sql, SystemConfigsEntity.class, systemName);
    }
    /**
     * Count all data
     * @return count
     */
    public int physicalCountAll() {
        String sql = "SELECT COUNT(*) FROM SYSTEM_CONFIGS";
        return executeQuerySingle(sql, Integer.class);
    }
    /**
     * Create row id.
     * @return row id
     */
    protected String createRowId() {
        return IDGen.get().gen("SYSTEM_CONFIGS");
    }
    /**
     * Physical Insert.
     * it is not create key on database sequence.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public SystemConfigsEntity rawPhysicalInsert(SystemConfigsEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_raw_insert.sql");
        executeUpdate(sql, 
            entity.getConfigName(), 
            entity.getSystemName(), 
            entity.getConfigValue(), 
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
    public SystemConfigsEntity physicalInsert(SystemConfigsEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_insert.sql");
        executeUpdate(sql, 
            entity.getConfigName(), 
            entity.getSystemName(), 
            entity.getConfigValue(), 
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
    public SystemConfigsEntity insert(Integer user, SystemConfigsEntity entity) {
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
    public SystemConfigsEntity insert(SystemConfigsEntity entity) {
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
    public SystemConfigsEntity physicalUpdate(SystemConfigsEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_update.sql");
        executeUpdate(sql, 
            entity.getConfigValue(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag(), 
            entity.getConfigName(), 
            entity.getSystemName());
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
    public SystemConfigsEntity update(Integer user, SystemConfigsEntity entity) {
        SystemConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
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
    public SystemConfigsEntity update(SystemConfigsEntity entity) {
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
    public SystemConfigsEntity save(Integer user, SystemConfigsEntity entity) {
        SystemConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
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
    public SystemConfigsEntity save(SystemConfigsEntity entity) {
        SystemConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
        if (db == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }
    /**
     * Physical Delete.
     * @param  configName configName
     * @param  systemName systemName
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(String configName, String systemName) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_delete.sql");
        executeUpdate(sql, configName, systemName);
    }
    /**
     * Physical Delete.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(SystemConfigsEntity entity) {
        physicalDelete(entity.getConfigName(), entity.getSystemName());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param  configName configName
     * @param  systemName systemName
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, String configName, String systemName) {
        SystemConfigsEntity db = selectOnKey(configName, systemName);
        db.setDeleteFlag(1);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * @param  configName configName
     * @param  systemName systemName
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(String configName, String systemName) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        delete(user, configName, systemName);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, SystemConfigsEntity entity) {
        delete(user, entity.getConfigName(), entity.getSystemName());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(SystemConfigsEntity entity) {
        delete(entity.getConfigName(), entity.getSystemName());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param  configName configName
     * @param  systemName systemName
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, String configName, String systemName) {
        SystemConfigsEntity db = physicalSelectOnKey(configName, systemName);
        db.setDeleteFlag(0);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param  configName configName
     * @param  systemName systemName
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(String configName, String systemName) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        activation(user, configName, systemName);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, SystemConfigsEntity entity) {
        activation(user, entity.getConfigName(), entity.getSystemName());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(SystemConfigsEntity entity) {
        activation(entity.getConfigName(), entity.getSystemName());

    }

}
