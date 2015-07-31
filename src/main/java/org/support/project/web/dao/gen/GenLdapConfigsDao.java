package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.LdapConfigsEntity;
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
 * LDAP認証設定
 */
@DI(instance=Instance.Singleton)
public class GenLdapConfigsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenLdapConfigsDao get() {
		return Container.getComp(GenLdapConfigsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<LdapConfigsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_physical_select_all.sql");
		return executeQueryList(sql, LdapConfigsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public LdapConfigsEntity physicalSelectOnKey(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, LdapConfigsEntity.class, systemName);
	}
	/**
	 * 全て取得 
	 */
	public List<LdapConfigsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_select_all.sql");
		return executeQueryList(sql, LdapConfigsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public LdapConfigsEntity selectOnKey(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_select_on_key.sql");
		return executeQuerySingle(sql, LdapConfigsEntity.class, systemName);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("LDAP_CONFIGS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LdapConfigsEntity rawPhysicalInsert(LdapConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getSystemName()
			, entity.getHost()
			, entity.getPort()
			, entity.getUseSsl()
			, entity.getUseTls()
			, entity.getBindDn()
			, entity.getBindPassword()
			, entity.getSalt()
			, entity.getBaseDn()
			, entity.getFilter()
			, entity.getIdAttr()
			, entity.getNameAttr()
			, entity.getMailAttr()
			, entity.getAdminCheckFilter()
			, entity.getAuthType()
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
	public LdapConfigsEntity physicalInsert(LdapConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_insert.sql");
		executeUpdate(sql, 
			entity.getSystemName()
			, entity.getHost()
			, entity.getPort()
			, entity.getUseSsl()
			, entity.getUseTls()
			, entity.getBindDn()
			, entity.getBindPassword()
			, entity.getSalt()
			, entity.getBaseDn()
			, entity.getFilter()
			, entity.getIdAttr()
			, entity.getNameAttr()
			, entity.getMailAttr()
			, entity.getAdminCheckFilter()
			, entity.getAuthType()
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
	public LdapConfigsEntity insert(Integer user, LdapConfigsEntity entity) {
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
	public LdapConfigsEntity insert(LdapConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LdapConfigsEntity physicalUpdate(LdapConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_update.sql");
		executeUpdate(sql, 
			entity.getHost()
			, entity.getPort()
			, entity.getUseSsl()
			, entity.getUseTls()
			, entity.getBindDn()
			, entity.getBindPassword()
			, entity.getSalt()
			, entity.getBaseDn()
			, entity.getFilter()
			, entity.getIdAttr()
			, entity.getNameAttr()
			, entity.getMailAttr()
			, entity.getAdminCheckFilter()
			, entity.getAuthType()
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
	public LdapConfigsEntity update(Integer user, LdapConfigsEntity entity) {
		LdapConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public LdapConfigsEntity update(LdapConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LdapConfigsEntity save(Integer user, LdapConfigsEntity entity) {
		LdapConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public LdapConfigsEntity save(LdapConfigsEntity entity) {
		LdapConfigsEntity db = selectOnKey(entity.getSystemName());
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
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LdapConfigsDao/LdapConfigsDao_delete.sql");
		executeUpdate(sql, systemName);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(LdapConfigsEntity entity) {
		physicalDelete(entity.getSystemName());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String systemName) {
		LdapConfigsEntity db = selectOnKey(systemName);
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
	public void delete(Integer user, LdapConfigsEntity entity) {
		delete(user, entity.getSystemName());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(LdapConfigsEntity entity) {
		delete(entity.getSystemName());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String systemName) {
		LdapConfigsEntity db = physicalSelectOnKey(systemName);
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
	public void activation(Integer user, LdapConfigsEntity entity) {
		activation(user, entity.getSystemName());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(LdapConfigsEntity entity) {
		activation(entity.getSystemName());

	}

}
