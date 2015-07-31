package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.RoleFunctionsEntity;
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
 * 機能にアクセスできる権限
 */
@DI(instance=Instance.Singleton)
public class GenRoleFunctionsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenRoleFunctionsDao get() {
		return Container.getComp(GenRoleFunctionsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<RoleFunctionsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_physical_select_all.sql");
		return executeQueryList(sql, RoleFunctionsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public RoleFunctionsEntity physicalSelectOnKey(String functionKey, Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, RoleFunctionsEntity.class, functionKey, roleId);
	}
	/**
	 * 全て取得 
	 */
	public List<RoleFunctionsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_select_all.sql");
		return executeQueryList(sql, RoleFunctionsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public RoleFunctionsEntity selectOnKey(String functionKey, Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_select_on_key.sql");
		return executeQuerySingle(sql, RoleFunctionsEntity.class, functionKey, roleId);
	}
	/**
	 * FUNCTION_KEY でリストを取得
	 */
	public List<RoleFunctionsEntity> selectOnFunctionKey(String functionKey) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_select_on_function_key.sql");
		return executeQueryList(sql, RoleFunctionsEntity.class, functionKey);
	}
	/**
	 * ROLE_ID でリストを取得
	 */
	public List<RoleFunctionsEntity> selectOnRoleId(Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_select_on_role_id.sql");
		return executeQueryList(sql, RoleFunctionsEntity.class, roleId);
	}
	/**
	 * FUNCTION_KEY でリストを取得
	 */
	public List<RoleFunctionsEntity> physicalSelectOnFunctionKey(String functionKey) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_physical_select_on_function_key.sql");
		return executeQueryList(sql, RoleFunctionsEntity.class, functionKey);
	}
	/**
	 * ROLE_ID でリストを取得
	 */
	public List<RoleFunctionsEntity> physicalSelectOnRoleId(Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_physical_select_on_role_id.sql");
		return executeQueryList(sql, RoleFunctionsEntity.class, roleId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("ROLE_FUNCTIONS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public RoleFunctionsEntity rawPhysicalInsert(RoleFunctionsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getFunctionKey()
			, entity.getRoleId()
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
	public RoleFunctionsEntity physicalInsert(RoleFunctionsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_insert.sql");
		executeUpdate(sql, 
			entity.getFunctionKey()
			, entity.getRoleId()
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
	public RoleFunctionsEntity insert(Integer user, RoleFunctionsEntity entity) {
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
	public RoleFunctionsEntity insert(RoleFunctionsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public RoleFunctionsEntity physicalUpdate(RoleFunctionsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_update.sql");
		executeUpdate(sql, 
			entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getFunctionKey()
			, entity.getRoleId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public RoleFunctionsEntity update(Integer user, RoleFunctionsEntity entity) {
		RoleFunctionsEntity db = selectOnKey(entity.getFunctionKey(), entity.getRoleId());
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
	public RoleFunctionsEntity update(RoleFunctionsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public RoleFunctionsEntity save(Integer user, RoleFunctionsEntity entity) {
		RoleFunctionsEntity db = selectOnKey(entity.getFunctionKey(), entity.getRoleId());
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
	public RoleFunctionsEntity save(RoleFunctionsEntity entity) {
		RoleFunctionsEntity db = selectOnKey(entity.getFunctionKey(), entity.getRoleId());
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
	public void physicalDelete(String functionKey, Integer roleId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/RoleFunctionsDao/RoleFunctionsDao_delete.sql");
		executeUpdate(sql, functionKey, roleId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(RoleFunctionsEntity entity) {
		physicalDelete(entity.getFunctionKey(), entity.getRoleId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String functionKey, Integer roleId) {
		RoleFunctionsEntity db = selectOnKey(functionKey, roleId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String functionKey, Integer roleId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, functionKey, roleId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, RoleFunctionsEntity entity) {
		delete(user, entity.getFunctionKey(), entity.getRoleId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(RoleFunctionsEntity entity) {
		delete(entity.getFunctionKey(), entity.getRoleId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String functionKey, Integer roleId) {
		RoleFunctionsEntity db = physicalSelectOnKey(functionKey, roleId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String functionKey, Integer roleId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, functionKey, roleId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, RoleFunctionsEntity entity) {
		activation(user, entity.getFunctionKey(), entity.getRoleId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(RoleFunctionsEntity entity) {
		activation(entity.getFunctionKey(), entity.getRoleId());

	}

}
