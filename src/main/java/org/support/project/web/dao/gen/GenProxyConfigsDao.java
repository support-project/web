package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.ProxyConfigsEntity;
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
 * プロキシ設定
 */
@DI(instance=Instance.Singleton)
public class GenProxyConfigsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenProxyConfigsDao get() {
		return Container.getComp(GenProxyConfigsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<ProxyConfigsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_physical_select_all.sql");
		return executeQueryList(sql, ProxyConfigsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public ProxyConfigsEntity physicalSelectOnKey(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, ProxyConfigsEntity.class, systemName);
	}
	/**
	 * 全て取得 
	 */
	public List<ProxyConfigsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_select_all.sql");
		return executeQueryList(sql, ProxyConfigsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public ProxyConfigsEntity selectOnKey(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_select_on_key.sql");
		return executeQuerySingle(sql, ProxyConfigsEntity.class, systemName);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("PROXY_CONFIGS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProxyConfigsEntity rawPhysicalInsert(ProxyConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getSystemName()
			, entity.getProxyHostName()
			, entity.getProxyPortNo()
			, entity.getProxyAuthType()
			, entity.getProxyAuthUserId()
			, entity.getProxyAuthPassword()
			, entity.getProxyAuthSalt()
			, entity.getProxyAuthPcName()
			, entity.getProxyAuthDomain()
			, entity.getThirdPartyCertificate()
			, entity.getTestUrl()
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
	public ProxyConfigsEntity physicalInsert(ProxyConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_insert.sql");
		executeUpdate(sql, 
			entity.getSystemName()
			, entity.getProxyHostName()
			, entity.getProxyPortNo()
			, entity.getProxyAuthType()
			, entity.getProxyAuthUserId()
			, entity.getProxyAuthPassword()
			, entity.getProxyAuthSalt()
			, entity.getProxyAuthPcName()
			, entity.getProxyAuthDomain()
			, entity.getThirdPartyCertificate()
			, entity.getTestUrl()
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
	public ProxyConfigsEntity insert(Integer user, ProxyConfigsEntity entity) {
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
	public ProxyConfigsEntity insert(ProxyConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProxyConfigsEntity physicalUpdate(ProxyConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_update.sql");
		executeUpdate(sql, 
			entity.getProxyHostName()
			, entity.getProxyPortNo()
			, entity.getProxyAuthType()
			, entity.getProxyAuthUserId()
			, entity.getProxyAuthPassword()
			, entity.getProxyAuthSalt()
			, entity.getProxyAuthPcName()
			, entity.getProxyAuthDomain()
			, entity.getThirdPartyCertificate()
			, entity.getTestUrl()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getSystemName()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProxyConfigsEntity update(Integer user, ProxyConfigsEntity entity) {
		ProxyConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public ProxyConfigsEntity update(ProxyConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProxyConfigsEntity save(Integer user, ProxyConfigsEntity entity) {
		ProxyConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public ProxyConfigsEntity save(ProxyConfigsEntity entity) {
		ProxyConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public void physicalDelete(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProxyConfigsDao/ProxyConfigsDao_delete.sql");
		executeUpdate(sql, systemName);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(ProxyConfigsEntity entity) {
		physicalDelete(entity.getSystemName());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String systemName) {
		ProxyConfigsEntity db = selectOnKey(systemName);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String systemName) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, systemName);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, ProxyConfigsEntity entity) {
		delete(user, entity.getSystemName());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(ProxyConfigsEntity entity) {
		delete(entity.getSystemName());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String systemName) {
		ProxyConfigsEntity db = physicalSelectOnKey(systemName);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String systemName) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, systemName);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, ProxyConfigsEntity entity) {
		activation(user, entity.getSystemName());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(ProxyConfigsEntity entity) {
		activation(entity.getSystemName());

	}

}
