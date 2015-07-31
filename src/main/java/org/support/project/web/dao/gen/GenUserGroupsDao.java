package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.UserGroupsEntity;
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
 * ユーザが所属するグループ
 */
@DI(instance=Instance.Singleton)
public class GenUserGroupsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenUserGroupsDao get() {
		return Container.getComp(GenUserGroupsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<UserGroupsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_physical_select_all.sql");
		return executeQueryList(sql, UserGroupsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public UserGroupsEntity physicalSelectOnKey(Integer groupId, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, UserGroupsEntity.class, groupId, userId);
	}
	/**
	 * 全て取得 
	 */
	public List<UserGroupsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_select_all.sql");
		return executeQueryList(sql, UserGroupsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public UserGroupsEntity selectOnKey(Integer groupId, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_select_on_key.sql");
		return executeQuerySingle(sql, UserGroupsEntity.class, groupId, userId);
	}
	/**
	 * GROUP_ID でリストを取得
	 */
	public List<UserGroupsEntity> selectOnGroupId(Integer groupId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_select_on_group_id.sql");
		return executeQueryList(sql, UserGroupsEntity.class, groupId);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<UserGroupsEntity> selectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_select_on_user_id.sql");
		return executeQueryList(sql, UserGroupsEntity.class, userId);
	}
	/**
	 * GROUP_ID でリストを取得
	 */
	public List<UserGroupsEntity> physicalSelectOnGroupId(Integer groupId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_physical_select_on_group_id.sql");
		return executeQueryList(sql, UserGroupsEntity.class, groupId);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<UserGroupsEntity> physicalSelectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_physical_select_on_user_id.sql");
		return executeQueryList(sql, UserGroupsEntity.class, userId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("USER_GROUPS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserGroupsEntity rawPhysicalInsert(UserGroupsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getGroupId()
			, entity.getUserId()
			, entity.getGroupRole()
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
	public UserGroupsEntity physicalInsert(UserGroupsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_insert.sql");
		executeUpdate(sql, 
			entity.getGroupId()
			, entity.getUserId()
			, entity.getGroupRole()
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
	public UserGroupsEntity insert(Integer user, UserGroupsEntity entity) {
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
	public UserGroupsEntity insert(UserGroupsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserGroupsEntity physicalUpdate(UserGroupsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_update.sql");
		executeUpdate(sql, 
			entity.getGroupRole()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getGroupId()
			, entity.getUserId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserGroupsEntity update(Integer user, UserGroupsEntity entity) {
		UserGroupsEntity db = selectOnKey(entity.getGroupId(), entity.getUserId());
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
	public UserGroupsEntity update(UserGroupsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public UserGroupsEntity save(Integer user, UserGroupsEntity entity) {
		UserGroupsEntity db = selectOnKey(entity.getGroupId(), entity.getUserId());
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
	public UserGroupsEntity save(UserGroupsEntity entity) {
		UserGroupsEntity db = selectOnKey(entity.getGroupId(), entity.getUserId());
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
	public void physicalDelete(Integer groupId, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserGroupsDao/UserGroupsDao_delete.sql");
		executeUpdate(sql, groupId, userId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(UserGroupsEntity entity) {
		physicalDelete(entity.getGroupId(), entity.getUserId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, Integer groupId, Integer userId) {
		UserGroupsEntity db = selectOnKey(groupId, userId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer groupId, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, groupId, userId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, UserGroupsEntity entity) {
		delete(user, entity.getGroupId(), entity.getUserId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(UserGroupsEntity entity) {
		delete(entity.getGroupId(), entity.getUserId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, Integer groupId, Integer userId) {
		UserGroupsEntity db = physicalSelectOnKey(groupId, userId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer groupId, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, groupId, userId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, UserGroupsEntity entity) {
		activation(user, entity.getGroupId(), entity.getUserId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(UserGroupsEntity entity) {
		activation(entity.getGroupId(), entity.getUserId());

	}

}
