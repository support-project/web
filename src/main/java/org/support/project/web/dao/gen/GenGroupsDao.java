package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.GroupsEntity;
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
 * グループ
 */
@DI(instance=Instance.Singleton)
public class GenGroupsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenGroupsDao get() {
		return Container.getComp(GenGroupsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<GroupsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_physical_select_all.sql");
		return executeQueryList(sql, GroupsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public GroupsEntity physicalSelectOnKey(Integer groupId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, GroupsEntity.class, groupId);
	}
	/**
	 * 全て取得 
	 */
	public List<GroupsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_select_all.sql");
		return executeQueryList(sql, GroupsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public GroupsEntity selectOnKey(Integer groupId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_select_on_key.sql");
		return executeQuerySingle(sql, GroupsEntity.class, groupId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("GROUPS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public GroupsEntity rawPhysicalInsert(GroupsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getGroupId()
			, entity.getGroupKey()
			, entity.getGroupName()
			, entity.getDescription()
			, entity.getParentGroupKey()
			, entity.getGroupClass()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		String driverClass = ConnectionManager.getInstance().getDriverClass(getConnectionName());
		if (ORMappingParameter.DRIVER_NAME_POSTGRESQL.equals(driverClass)) {
			String setValSql = "select setval('GROUPS_GROUP_ID_seq', (select max(GROUP_ID) from GROUPS));";
			executeQuerySingle(setValSql, Long.class);
		}
		return entity;
	}
	/**
	 * 登録(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public GroupsEntity physicalInsert(GroupsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_insert.sql");
		Class<?> type = PropertyUtil.getPropertyType(entity, "groupId");
		Object key = executeInsert(sql, type, 
			entity.getGroupKey()
			, entity.getGroupName()
			, entity.getDescription()
			, entity.getParentGroupKey()
			, entity.getGroupClass()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		PropertyUtil.setPropertyValue(entity, "groupId", key);
		return entity;
	}
	/**
	 * 登録(登録ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public GroupsEntity insert(Integer user, GroupsEntity entity) {
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
	public GroupsEntity insert(GroupsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public GroupsEntity physicalUpdate(GroupsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_update.sql");
		executeUpdate(sql, 
			entity.getGroupKey()
			, entity.getGroupName()
			, entity.getDescription()
			, entity.getParentGroupKey()
			, entity.getGroupClass()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getGroupId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public GroupsEntity update(Integer user, GroupsEntity entity) {
		GroupsEntity db = selectOnKey(entity.getGroupId());
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
	public GroupsEntity update(GroupsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public GroupsEntity save(Integer user, GroupsEntity entity) {
		GroupsEntity db = selectOnKey(entity.getGroupId());
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
	public GroupsEntity save(GroupsEntity entity) {
		GroupsEntity db = selectOnKey(entity.getGroupId());
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
	public void physicalDelete(Integer groupId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/GroupsDao/GroupsDao_delete.sql");
		executeUpdate(sql, groupId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(GroupsEntity entity) {
		physicalDelete(entity.getGroupId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, Integer groupId) {
		GroupsEntity db = selectOnKey(groupId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer groupId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, groupId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, GroupsEntity entity) {
		delete(user, entity.getGroupId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(GroupsEntity entity) {
		delete(entity.getGroupId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, Integer groupId) {
		GroupsEntity db = physicalSelectOnKey(groupId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer groupId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, groupId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, GroupsEntity entity) {
		activation(user, entity.getGroupId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(GroupsEntity entity) {
		activation(entity.getGroupId());

	}

}
