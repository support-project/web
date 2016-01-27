package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.SystemAttributesEntity;
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
 * システム付加情報
 */
@DI(instance=Instance.Singleton)
public class GenSystemAttributesDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenSystemAttributesDao get() {
		return Container.getComp(GenSystemAttributesDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<SystemAttributesEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_physical_select_all.sql");
		return executeQueryList(sql, SystemAttributesEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public SystemAttributesEntity physicalSelectOnKey(String configName, String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, SystemAttributesEntity.class, configName, systemName);
	}
	/**
	 * 全て取得 
	 */
	public List<SystemAttributesEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_select_all.sql");
		return executeQueryList(sql, SystemAttributesEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public SystemAttributesEntity selectOnKey(String configName, String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_select_on_key.sql");
		return executeQuerySingle(sql, SystemAttributesEntity.class, configName, systemName);
	}
	/**
	 * CONFIG_NAME でリストを取得
	 */
	public List<SystemAttributesEntity> selectOnConfigName(String configName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_select_on_config_name.sql");
		return executeQueryList(sql, SystemAttributesEntity.class, configName);
	}
	/**
	 * SYSTEM_NAME でリストを取得
	 */
	public List<SystemAttributesEntity> selectOnSystemName(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_select_on_system_name.sql");
		return executeQueryList(sql, SystemAttributesEntity.class, systemName);
	}
	/**
	 * CONFIG_NAME でリストを取得
	 */
	public List<SystemAttributesEntity> physicalSelectOnConfigName(String configName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_physical_select_on_config_name.sql");
		return executeQueryList(sql, SystemAttributesEntity.class, configName);
	}
	/**
	 * SYSTEM_NAME でリストを取得
	 */
	public List<SystemAttributesEntity> physicalSelectOnSystemName(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_physical_select_on_system_name.sql");
		return executeQueryList(sql, SystemAttributesEntity.class, systemName);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("SYSTEM_ATTRIBUTES");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemAttributesEntity rawPhysicalInsert(SystemAttributesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_raw_insert.sql");
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
	public SystemAttributesEntity physicalInsert(SystemAttributesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_insert.sql");
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
	public SystemAttributesEntity insert(Integer user, SystemAttributesEntity entity) {
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
	public SystemAttributesEntity insert(SystemAttributesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemAttributesEntity physicalUpdate(SystemAttributesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_update.sql");
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
	public SystemAttributesEntity update(Integer user, SystemAttributesEntity entity) {
		SystemAttributesEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
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
	public SystemAttributesEntity update(SystemAttributesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public SystemAttributesEntity save(Integer user, SystemAttributesEntity entity) {
		SystemAttributesEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
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
	public SystemAttributesEntity save(SystemAttributesEntity entity) {
		SystemAttributesEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName());
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
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/SystemAttributesDao/SystemAttributesDao_delete.sql");
		executeUpdate(sql, configName, systemName);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(SystemAttributesEntity entity) {
		physicalDelete(entity.getConfigName(), entity.getSystemName());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String configName, String systemName) {
		SystemAttributesEntity db = selectOnKey(configName, systemName);
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
	public void delete(Integer user, SystemAttributesEntity entity) {
		delete(user, entity.getConfigName(), entity.getSystemName());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(SystemAttributesEntity entity) {
		delete(entity.getConfigName(), entity.getSystemName());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String configName, String systemName) {
		SystemAttributesEntity db = physicalSelectOnKey(configName, systemName);
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
	public void activation(Integer user, SystemAttributesEntity entity) {
		activation(user, entity.getConfigName(), entity.getSystemName());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(SystemAttributesEntity entity) {
		activation(entity.getConfigName(), entity.getSystemName());

	}

}
