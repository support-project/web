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
 */
@DI(instance=Instance.Singleton)
public class GenSystemConfigsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenSystemConfigsDao get() {
		return Container.getComp(GenSystemConfigsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<SystemConfigsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_all.sql");
		return executeQueryList(sql, SystemConfigsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public SystemConfigsEntity physicalSelectOnKey(String configName, String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, SystemConfigsEntity.class, configName, systemName);
	}
	/**
	 * 全て取得 
	 */
	public List<SystemConfigsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_all.sql");
		return executeQueryList(sql, SystemConfigsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public SystemConfigsEntity selectOnKey(String configName, String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_on_key.sql");
		return executeQuerySingle(sql, SystemConfigsEntity.class, configName, systemName);
	}
	/**
	 * CONFIG_NAME でリストを取得
	 */
	public List<SystemConfigsEntity> selectOnConfigName(String configName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_on_config_name.sql");
		return executeQueryList(sql, SystemConfigsEntity.class, configName);
	}
	/**
	 * SYSTEM_NAME でリストを取得
	 */
	public List<SystemConfigsEntity> selectOnSystemName(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_select_on_system_name.sql");
		return executeQueryList(sql, SystemConfigsEntity.class, systemName);
	}
	/**
	 * CONFIG_NAME でリストを取得
	 */
	public List<SystemConfigsEntity> physicalSelectOnConfigName(String configName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_on_config_name.sql");
		return executeQueryList(sql, SystemConfigsEntity.class, configName);
	}
	/**
	 * SYSTEM_NAME でリストを取得
	 */
	public List<SystemConfigsEntity> physicalSelectOnSystemName(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_physical_select_on_system_name.sql");
		return executeQueryList(sql, SystemConfigsEntity.class, systemName);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("SYSTEM_CONFIGS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity rawPhysicalInsert(SystemConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getConfigName()
			, entity.getSystemName()
			, entity.getConfigValue()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		return entity;
	}
	/**
	 * 登録(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity physicalInsert(SystemConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_insert.sql");
		executeUpdate(sql, 
			entity.getConfigName()
			, entity.getSystemName()
			, entity.getConfigValue()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		return entity;
	}
	/**
	 * 登録(登録ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
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
	 * 登録
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity insert(SystemConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity physicalUpdate(SystemConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_update.sql");
		executeUpdate(sql, 
			entity.getConfigValue()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getConfigName()
			, entity.getSystemName()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
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
	 * 更新
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity update(SystemConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity save(Integer user, SystemConfigsEntity entity) {
		SystemConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
		if (db == null) {
			return insert(user, entity);
		} else {
			return update(user, entity);
		}
	}
	/**
	 * 保存(存在しなければ登録、存在すれば更新) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemConfigsEntity save(SystemConfigsEntity entity) {
		SystemConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
		if (db == null) {
			return insert(entity);
		} else {
			return update(entity);
		}
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(String configName, String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemConfigsDao/SystemConfigsDao_delete.sql");
		executeUpdate(sql, configName, systemName);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(SystemConfigsEntity entity) {
		physicalDelete(entity.getConfigName(), entity.getSystemName());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String configName, String systemName) {
		SystemConfigsEntity db = selectOnKey(configName, systemName);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String configName, String systemName) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, configName, systemName);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, SystemConfigsEntity entity) {
		delete(user, entity.getConfigName(), entity.getSystemName());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(SystemConfigsEntity entity) {
		delete(entity.getConfigName(), entity.getSystemName());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String configName, String systemName) {
		SystemConfigsEntity db = physicalSelectOnKey(configName, systemName);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String configName, String systemName) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, configName, systemName);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, SystemConfigsEntity entity) {
		activation(user, entity.getConfigName(), entity.getSystemName());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(SystemConfigsEntity entity) {
		activation(entity.getConfigName(), entity.getSystemName());

	}

}
