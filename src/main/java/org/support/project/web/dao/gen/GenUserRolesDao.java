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
 */
@DI(instance=Instance.Singleton)
public class GenUserRolesDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenUserRolesDao get() {
		return Container.getComp(GenUserRolesDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<UserRolesEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_all.sql");
		return executeQueryList(sql, UserRolesEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public UserRolesEntity physicalSelectOnKey(Integer roleId, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, UserRolesEntity.class, roleId, userId);
	}
	/**
	 * 全て取得 
	 */
	public List<UserRolesEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_all.sql");
		return executeQueryList(sql, UserRolesEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public UserRolesEntity selectOnKey(Integer roleId, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_on_key.sql");
		return executeQuerySingle(sql, UserRolesEntity.class, roleId, userId);
	}
	/**
	 * ROLE_ID でリストを取得
	 */
	public List<UserRolesEntity> selectOnRoleId(Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_on_role_id.sql");
		return executeQueryList(sql, UserRolesEntity.class, roleId);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<UserRolesEntity> selectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_select_on_user_id.sql");
		return executeQueryList(sql, UserRolesEntity.class, userId);
	}
	/**
	 * ROLE_ID でリストを取得
	 */
	public List<UserRolesEntity> physicalSelectOnRoleId(Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_on_role_id.sql");
		return executeQueryList(sql, UserRolesEntity.class, roleId);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<UserRolesEntity> physicalSelectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_physical_select_on_user_id.sql");
		return executeQueryList(sql, UserRolesEntity.class, userId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("USER_ROLES");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserRolesEntity rawPhysicalInsert(UserRolesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getRoleId()
			, entity.getUserId()
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
	public UserRolesEntity physicalInsert(UserRolesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_insert.sql");
		executeUpdate(sql, 
			entity.getRoleId()
			, entity.getUserId()
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
	 * 登録
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserRolesEntity insert(UserRolesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserRolesEntity physicalUpdate(UserRolesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_update.sql");
		executeUpdate(sql, 
			entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getRoleId()
			, entity.getUserId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
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
	 * 更新
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserRolesEntity update(UserRolesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserRolesEntity save(Integer user, UserRolesEntity entity) {
		UserRolesEntity db = selectOnKey(entity.getRoleId(), entity.getUserId());
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
	public UserRolesEntity save(UserRolesEntity entity) {
		UserRolesEntity db = selectOnKey(entity.getRoleId(), entity.getUserId());
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
	public void physicalDelete(Integer roleId, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserRolesDao/UserRolesDao_delete.sql");
		executeUpdate(sql, roleId, userId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(UserRolesEntity entity) {
		physicalDelete(entity.getRoleId(), entity.getUserId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, Integer roleId, Integer userId) {
		UserRolesEntity db = selectOnKey(roleId, userId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer roleId, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, roleId, userId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, UserRolesEntity entity) {
		delete(user, entity.getRoleId(), entity.getUserId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(UserRolesEntity entity) {
		delete(entity.getRoleId(), entity.getUserId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, Integer roleId, Integer userId) {
		UserRolesEntity db = physicalSelectOnKey(roleId, userId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer roleId, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, roleId, userId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, UserRolesEntity entity) {
		activation(user, entity.getRoleId(), entity.getUserId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(UserRolesEntity entity) {
		activation(entity.getRoleId(), entity.getUserId());

	}
}
