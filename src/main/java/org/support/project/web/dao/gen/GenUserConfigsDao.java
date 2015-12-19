package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.UserConfigsEntity;
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
 * ユーザ設定
 */
@DI(instance=Instance.Singleton)
public class GenUserConfigsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenUserConfigsDao get() {
		return Container.getComp(GenUserConfigsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<UserConfigsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_physical_select_all.sql");
		return executeQueryList(sql, UserConfigsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public UserConfigsEntity physicalSelectOnKey(String configName, String systemName, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, UserConfigsEntity.class, configName, systemName, userId);
	}
	/**
	 * 全て取得 
	 */
	public List<UserConfigsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_select_all.sql");
		return executeQueryList(sql, UserConfigsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public UserConfigsEntity selectOnKey(String configName, String systemName, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_select_on_key.sql");
		return executeQuerySingle(sql, UserConfigsEntity.class, configName, systemName, userId);
	}
	/**
	 * CONFIG_NAME でリストを取得
	 */
	public List<UserConfigsEntity> selectOnConfigName(String configName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_select_on_config_name.sql");
		return executeQueryList(sql, UserConfigsEntity.class, configName);
	}
	/**
	 * SYSTEM_NAME でリストを取得
	 */
	public List<UserConfigsEntity> selectOnSystemName(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_select_on_system_name.sql");
		return executeQueryList(sql, UserConfigsEntity.class, systemName);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<UserConfigsEntity> selectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_select_on_user_id.sql");
		return executeQueryList(sql, UserConfigsEntity.class, userId);
	}
	/**
	 * CONFIG_NAME でリストを取得
	 */
	public List<UserConfigsEntity> physicalSelectOnConfigName(String configName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_physical_select_on_config_name.sql");
		return executeQueryList(sql, UserConfigsEntity.class, configName);
	}
	/**
	 * SYSTEM_NAME でリストを取得
	 */
	public List<UserConfigsEntity> physicalSelectOnSystemName(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_physical_select_on_system_name.sql");
		return executeQueryList(sql, UserConfigsEntity.class, systemName);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<UserConfigsEntity> physicalSelectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_physical_select_on_user_id.sql");
		return executeQueryList(sql, UserConfigsEntity.class, userId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("USER_CONFIGS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserConfigsEntity rawPhysicalInsert(UserConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getConfigName()
			, entity.getSystemName()
			, entity.getUserId()
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
	public UserConfigsEntity physicalInsert(UserConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_insert.sql");
		executeUpdate(sql, 
			entity.getConfigName()
			, entity.getSystemName()
			, entity.getUserId()
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
	public UserConfigsEntity insert(Integer user, UserConfigsEntity entity) {
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
	public UserConfigsEntity insert(UserConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserConfigsEntity physicalUpdate(UserConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_update.sql");
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
			, entity.getUserId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserConfigsEntity update(Integer user, UserConfigsEntity entity) {
		UserConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName(), entity.getUserId());
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
	public UserConfigsEntity update(UserConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserConfigsEntity save(Integer user, UserConfigsEntity entity) {
		UserConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName(), entity.getUserId());
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
	public UserConfigsEntity save(UserConfigsEntity entity) {
		UserConfigsEntity db = selectOnKey(entity.getConfigName(), entity.getSystemName(), entity.getUserId());
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
	public void physicalDelete(String configName, String systemName, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserConfigsDao/UserConfigsDao_delete.sql");
		executeUpdate(sql, configName, systemName, userId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(UserConfigsEntity entity) {
		physicalDelete(entity.getConfigName(), entity.getSystemName(), entity.getUserId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String configName, String systemName, Integer userId) {
		UserConfigsEntity db = selectOnKey(configName, systemName, userId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String configName, String systemName, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, configName, systemName, userId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, UserConfigsEntity entity) {
		delete(user, entity.getConfigName(), entity.getSystemName(), entity.getUserId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(UserConfigsEntity entity) {
		delete(entity.getConfigName(), entity.getSystemName(), entity.getUserId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String configName, String systemName, Integer userId) {
		UserConfigsEntity db = physicalSelectOnKey(configName, systemName, userId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String configName, String systemName, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, configName, systemName, userId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, UserConfigsEntity entity) {
		activation(user, entity.getConfigName(), entity.getSystemName(), entity.getUserId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(UserConfigsEntity entity) {
		activation(entity.getConfigName(), entity.getSystemName(), entity.getUserId());

	}

}
