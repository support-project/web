package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.MailConfigsEntity;
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
 * メール設定
 */
@DI(instance=Instance.Singleton)
public class GenMailConfigsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenMailConfigsDao get() {
		return Container.getComp(GenMailConfigsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<MailConfigsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_physical_select_all.sql");
		return executeQueryList(sql, MailConfigsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public MailConfigsEntity physicalSelectOnKey(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, MailConfigsEntity.class, systemName);
	}
	/**
	 * 全て取得 
	 */
	public List<MailConfigsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_select_all.sql");
		return executeQueryList(sql, MailConfigsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public MailConfigsEntity selectOnKey(String systemName) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_select_on_key.sql");
		return executeQuerySingle(sql, MailConfigsEntity.class, systemName);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("MAIL_CONFIGS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailConfigsEntity rawPhysicalInsert(MailConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getSystemName()
			, entity.getHost()
			, entity.getPort()
			, entity.getAuthType()
			, entity.getSmtpId()
			, entity.getSmtpPassword()
			, entity.getSalt()
			, entity.getFromAddress()
			, entity.getFromName()
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
	public MailConfigsEntity physicalInsert(MailConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_insert.sql");
		executeUpdate(sql, 
			entity.getSystemName()
			, entity.getHost()
			, entity.getPort()
			, entity.getAuthType()
			, entity.getSmtpId()
			, entity.getSmtpPassword()
			, entity.getSalt()
			, entity.getFromAddress()
			, entity.getFromName()
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
	public MailConfigsEntity insert(Integer user, MailConfigsEntity entity) {
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
	public MailConfigsEntity insert(MailConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailConfigsEntity physicalUpdate(MailConfigsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_update.sql");
		executeUpdate(sql, 
			entity.getHost()
			, entity.getPort()
			, entity.getAuthType()
			, entity.getSmtpId()
			, entity.getSmtpPassword()
			, entity.getSalt()
			, entity.getFromAddress()
			, entity.getFromName()
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
	public MailConfigsEntity update(Integer user, MailConfigsEntity entity) {
		MailConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public MailConfigsEntity update(MailConfigsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailConfigsEntity save(Integer user, MailConfigsEntity entity) {
		MailConfigsEntity db = selectOnKey(entity.getSystemName());
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
	public MailConfigsEntity save(MailConfigsEntity entity) {
		MailConfigsEntity db = selectOnKey(entity.getSystemName());
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
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailConfigsDao/MailConfigsDao_delete.sql");
		executeUpdate(sql, systemName);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(MailConfigsEntity entity) {
		physicalDelete(entity.getSystemName());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String systemName) {
		MailConfigsEntity db = selectOnKey(systemName);
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
	public void delete(Integer user, MailConfigsEntity entity) {
		delete(user, entity.getSystemName());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(MailConfigsEntity entity) {
		delete(entity.getSystemName());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String systemName) {
		MailConfigsEntity db = physicalSelectOnKey(systemName);
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
	public void activation(Integer user, MailConfigsEntity entity) {
		activation(user, entity.getSystemName());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(MailConfigsEntity entity) {
		activation(entity.getSystemName());

	}

}
