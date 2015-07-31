package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.AccessLogsEntity;
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
 * ACCESS_LOGS
 */
@DI(instance=Instance.Singleton)
public class GenAccessLogsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenAccessLogsDao get() {
		return Container.getComp(GenAccessLogsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<AccessLogsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_physical_select_all.sql");
		return executeQueryList(sql, AccessLogsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public AccessLogsEntity physicalSelectOnKey(Long no) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, AccessLogsEntity.class, no);
	}
	/**
	 * 全て取得 
	 */
	public List<AccessLogsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_select_all.sql");
		return executeQueryList(sql, AccessLogsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public AccessLogsEntity selectOnKey(Long no) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_select_on_key.sql");
		return executeQuerySingle(sql, AccessLogsEntity.class, no);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("ACCESS_LOGS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public AccessLogsEntity rawPhysicalInsert(AccessLogsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getNo()
			, entity.getPath()
			, entity.getIpAddress()
			, entity.getUserAgent()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		String driverClass = ConnectionManager.getInstance().getDriverClass(getConnectionName());
		if (ORMappingParameter.DRIVER_NAME_POSTGRESQL.equals(driverClass)) {
			String setValSql = "select setval('ACCESS_LOGS_NO_seq', (select max(NO) from ACCESS_LOGS));";
			executeQuerySingle(setValSql, Long.class);
		}
		return entity;
	}
	/**
	 * 登録(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public AccessLogsEntity physicalInsert(AccessLogsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_insert.sql");
		Class<?> type = PropertyUtil.getPropertyType(entity, "no");
		Object key = executeInsert(sql, type, 
			entity.getPath()
			, entity.getIpAddress()
			, entity.getUserAgent()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
		);
		PropertyUtil.setPropertyValue(entity, "no", key);
		return entity;
	}
	/**
	 * 登録(登録ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public AccessLogsEntity insert(Integer user, AccessLogsEntity entity) {
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
	public AccessLogsEntity insert(AccessLogsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public AccessLogsEntity physicalUpdate(AccessLogsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_update.sql");
		executeUpdate(sql, 
			entity.getPath()
			, entity.getIpAddress()
			, entity.getUserAgent()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getNo()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public AccessLogsEntity update(Integer user, AccessLogsEntity entity) {
		AccessLogsEntity db = selectOnKey(entity.getNo());
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
	public AccessLogsEntity update(AccessLogsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public AccessLogsEntity save(Integer user, AccessLogsEntity entity) {
		AccessLogsEntity db = selectOnKey(entity.getNo());
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
	public AccessLogsEntity save(AccessLogsEntity entity) {
		AccessLogsEntity db = selectOnKey(entity.getNo());
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
	public void physicalDelete(Long no) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/AccessLogsDao/AccessLogsDao_delete.sql");
		executeUpdate(sql, no);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(AccessLogsEntity entity) {
		physicalDelete(entity.getNo());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, Long no) {
		AccessLogsEntity db = selectOnKey(no);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Long no) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, no);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, AccessLogsEntity entity) {
		delete(user, entity.getNo());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(AccessLogsEntity entity) {
		delete(entity.getNo());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, Long no) {
		AccessLogsEntity db = physicalSelectOnKey(no);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Long no) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, no);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, AccessLogsEntity entity) {
		activation(user, entity.getNo());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(AccessLogsEntity entity) {
		activation(entity.getNo());

	}

}
