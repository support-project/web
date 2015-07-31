package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.FunctionsEntity;
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
 * 機能
 */
@DI(instance=Instance.Singleton)
public class GenFunctionsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenFunctionsDao get() {
		return Container.getComp(GenFunctionsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<FunctionsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_physical_select_all.sql");
		return executeQueryList(sql, FunctionsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public FunctionsEntity physicalSelectOnKey(String functionKey) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, FunctionsEntity.class, functionKey);
	}
	/**
	 * 全て取得 
	 */
	public List<FunctionsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_select_all.sql");
		return executeQueryList(sql, FunctionsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public FunctionsEntity selectOnKey(String functionKey) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_select_on_key.sql");
		return executeQuerySingle(sql, FunctionsEntity.class, functionKey);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("FUNCTIONS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public FunctionsEntity rawPhysicalInsert(FunctionsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getFunctionKey()
			, entity.getDescription()
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
	public FunctionsEntity physicalInsert(FunctionsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_insert.sql");
		executeUpdate(sql, 
			entity.getFunctionKey()
			, entity.getDescription()
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
	public FunctionsEntity insert(Integer user, FunctionsEntity entity) {
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
	public FunctionsEntity insert(FunctionsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public FunctionsEntity physicalUpdate(FunctionsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_update.sql");
		executeUpdate(sql, 
			entity.getDescription()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getFunctionKey()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public FunctionsEntity update(Integer user, FunctionsEntity entity) {
		FunctionsEntity db = selectOnKey(entity.getFunctionKey());
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
	public FunctionsEntity update(FunctionsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public FunctionsEntity save(Integer user, FunctionsEntity entity) {
		FunctionsEntity db = selectOnKey(entity.getFunctionKey());
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
	public FunctionsEntity save(FunctionsEntity entity) {
		FunctionsEntity db = selectOnKey(entity.getFunctionKey());
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
	public void physicalDelete(String functionKey) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/FunctionsDao/FunctionsDao_delete.sql");
		executeUpdate(sql, functionKey);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(FunctionsEntity entity) {
		physicalDelete(entity.getFunctionKey());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String functionKey) {
		FunctionsEntity db = selectOnKey(functionKey);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String functionKey) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, functionKey);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, FunctionsEntity entity) {
		delete(user, entity.getFunctionKey());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(FunctionsEntity entity) {
		delete(entity.getFunctionKey());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String functionKey) {
		FunctionsEntity db = physicalSelectOnKey(functionKey);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String functionKey) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, functionKey);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, FunctionsEntity entity) {
		activation(user, entity.getFunctionKey());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(FunctionsEntity entity) {
		activation(entity.getFunctionKey());

	}

}
