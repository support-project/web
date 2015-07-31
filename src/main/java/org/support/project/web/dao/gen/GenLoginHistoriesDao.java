package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.LoginHistoriesEntity;
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
 * ログイン履歴
 */
@DI(instance=Instance.Singleton)
public class GenLoginHistoriesDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenLoginHistoriesDao get() {
		return Container.getComp(GenLoginHistoriesDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<LoginHistoriesEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_physical_select_all.sql");
		return executeQueryList(sql, LoginHistoriesEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public LoginHistoriesEntity physicalSelectOnKey(Double loginCount, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, LoginHistoriesEntity.class, loginCount, userId);
	}
	/**
	 * 全て取得 
	 */
	public List<LoginHistoriesEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_select_all.sql");
		return executeQueryList(sql, LoginHistoriesEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public LoginHistoriesEntity selectOnKey(Double loginCount, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_select_on_key.sql");
		return executeQuerySingle(sql, LoginHistoriesEntity.class, loginCount, userId);
	}
	/**
	 * LOGIN_COUNT でリストを取得
	 */
	public List<LoginHistoriesEntity> selectOnLoginCount(Double loginCount) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_select_on_login_count.sql");
		return executeQueryList(sql, LoginHistoriesEntity.class, loginCount);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<LoginHistoriesEntity> selectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_select_on_user_id.sql");
		return executeQueryList(sql, LoginHistoriesEntity.class, userId);
	}
	/**
	 * LOGIN_COUNT でリストを取得
	 */
	public List<LoginHistoriesEntity> physicalSelectOnLoginCount(Double loginCount) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_physical_select_on_login_count.sql");
		return executeQueryList(sql, LoginHistoriesEntity.class, loginCount);
	}
	/**
	 * USER_ID でリストを取得
	 */
	public List<LoginHistoriesEntity> physicalSelectOnUserId(Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_physical_select_on_user_id.sql");
		return executeQueryList(sql, LoginHistoriesEntity.class, userId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("LOGIN_HISTORIES");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LoginHistoriesEntity rawPhysicalInsert(LoginHistoriesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getLoginCount()
			, entity.getUserId()
			, entity.getLodinDateTime()
			, entity.getIpAddress()
			, entity.getUserAgent()
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
	public LoginHistoriesEntity physicalInsert(LoginHistoriesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_insert.sql");
		executeUpdate(sql, 
			entity.getLoginCount()
			, entity.getUserId()
			, entity.getLodinDateTime()
			, entity.getIpAddress()
			, entity.getUserAgent()
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
	public LoginHistoriesEntity insert(Integer user, LoginHistoriesEntity entity) {
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
	public LoginHistoriesEntity insert(LoginHistoriesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LoginHistoriesEntity physicalUpdate(LoginHistoriesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_update.sql");
		executeUpdate(sql, 
			entity.getLodinDateTime()
			, entity.getIpAddress()
			, entity.getUserAgent()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getLoginCount()
			, entity.getUserId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LoginHistoriesEntity update(Integer user, LoginHistoriesEntity entity) {
		LoginHistoriesEntity db = selectOnKey(entity.getLoginCount(), entity.getUserId());
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
	public LoginHistoriesEntity update(LoginHistoriesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LoginHistoriesEntity save(Integer user, LoginHistoriesEntity entity) {
		LoginHistoriesEntity db = selectOnKey(entity.getLoginCount(), entity.getUserId());
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
	public LoginHistoriesEntity save(LoginHistoriesEntity entity) {
		LoginHistoriesEntity db = selectOnKey(entity.getLoginCount(), entity.getUserId());
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
	public void physicalDelete(Double loginCount, Integer userId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LoginHistoriesDao/LoginHistoriesDao_delete.sql");
		executeUpdate(sql, loginCount, userId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(LoginHistoriesEntity entity) {
		physicalDelete(entity.getLoginCount(), entity.getUserId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, Double loginCount, Integer userId) {
		LoginHistoriesEntity db = selectOnKey(loginCount, userId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Double loginCount, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, loginCount, userId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, LoginHistoriesEntity entity) {
		delete(user, entity.getLoginCount(), entity.getUserId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(LoginHistoriesEntity entity) {
		delete(entity.getLoginCount(), entity.getUserId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, Double loginCount, Integer userId) {
		LoginHistoriesEntity db = physicalSelectOnKey(loginCount, userId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Double loginCount, Integer userId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, loginCount, userId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, LoginHistoriesEntity entity) {
		activation(user, entity.getLoginCount(), entity.getUserId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(LoginHistoriesEntity entity) {
		activation(entity.getLoginCount(), entity.getUserId());

	}

}
