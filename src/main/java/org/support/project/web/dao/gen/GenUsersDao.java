package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.UsersEntity;
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
 * ユーザ
 */
@DI(instance=Instance.Singleton)
public class GenUsersDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenUsersDao get() {
		return Container.getComp(GenUsersDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<UsersEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_physical_select_all.sql");
		return executeQueryList(sql, UsersEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public UsersEntity physicalSelectOnKey(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, UsersEntity.class, userId);
	}
	/**
	 * 全て取得 
	 */
	public List<UsersEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_select_all.sql");
		return executeQueryList(sql, UsersEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public UsersEntity selectOnKey(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_select_on_key.sql");
		return executeQuerySingle(sql, UsersEntity.class, userId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("USERS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UsersEntity rawPhysicalInsert(UsersEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getUserId()
			, entity.getUserKey()
			, entity.getUserName()
			, entity.getPassword()
			, entity.getSalt()
			, entity.getLocaleKey()
			, entity.getMailAddress()
			, entity.getAuthLdap()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		String driverClass = ConnectionManager.getInstance().getDriverClass(getConnectionName());
		if (ORMappingParameter.DRIVER_NAME_POSTGRESQL.equals(driverClass)) {
			String setValSql = "select setval('USERS_USER_ID_seq', (select max(USER_ID) from USERS));";
			executeQuerySingle(setValSql, Long.class);
		}
		return entity;
	}
	/**
	 * 登録(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UsersEntity physicalInsert(UsersEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_insert.sql");
		Class<?> type = PropertyUtil.getPropertyType(entity, "userId");
		Object key = executeInsert(sql, type, 
			entity.getUserKey()
			, entity.getUserName()
			, entity.getPassword()
			, entity.getSalt()
			, entity.getLocaleKey()
			, entity.getMailAddress()
			, entity.getAuthLdap()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		PropertyUtil.setPropertyValue(entity, "userId", key);
		return entity;
	}
	/**
	 * 登録(登録ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UsersEntity insert(Integer user, UsersEntity entity) {
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
	public UsersEntity insert(UsersEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UsersEntity physicalUpdate(UsersEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_update.sql");
		executeUpdate(sql, 
			entity.getUserKey()
			, entity.getUserName()
			, entity.getPassword()
			, entity.getSalt()
			, entity.getLocaleKey()
			, entity.getMailAddress()
			, entity.getAuthLdap()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getUserId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UsersEntity update(Integer user, UsersEntity entity) {
		UsersEntity db = selectOnKey(entity.getUserId());
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
	public UsersEntity update(UsersEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UsersEntity save(Integer user, UsersEntity entity) {
		UsersEntity db = selectOnKey(entity.getUserId());
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
	public UsersEntity save(UsersEntity entity) {
		UsersEntity db = selectOnKey(entity.getUserId());
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
	public void physicalDelete(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UsersDao/UsersDao_delete.sql");
		executeUpdate(sql, userId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(UsersEntity entity) {
		physicalDelete(entity.getUserId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, Integer userId) {
		UsersEntity db = selectOnKey(userId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, userId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, UsersEntity entity) {
		delete(user, entity.getUserId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(UsersEntity entity) {
		delete(entity.getUserId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, Integer userId) {
		UsersEntity db = physicalSelectOnKey(userId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, userId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, UsersEntity entity) {
		activation(user, entity.getUserId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(UsersEntity entity) {
		activation(entity.getUserId());

	}
}
