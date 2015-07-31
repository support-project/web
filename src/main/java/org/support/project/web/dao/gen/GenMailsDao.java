package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.MailsEntity;
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
 * メール
 */
@DI(instance=Instance.Singleton)
public class GenMailsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenMailsDao get() {
		return Container.getComp(GenMailsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<MailsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_physical_select_all.sql");
		return executeQueryList(sql, MailsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public MailsEntity physicalSelectOnKey(String mailId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, MailsEntity.class, mailId);
	}
	/**
	 * 全て取得 
	 */
	public List<MailsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_select_all.sql");
		return executeQueryList(sql, MailsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public MailsEntity selectOnKey(String mailId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_select_on_key.sql");
		return executeQuerySingle(sql, MailsEntity.class, mailId);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("MAILS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailsEntity rawPhysicalInsert(MailsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getMailId()
			, entity.getStatus()
			, entity.getToAddress()
			, entity.getToName()
			, entity.getFromAddress()
			, entity.getFromName()
			, entity.getTitle()
			, entity.getContent()
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
	public MailsEntity physicalInsert(MailsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_insert.sql");
		executeUpdate(sql, 
			entity.getMailId()
			, entity.getStatus()
			, entity.getToAddress()
			, entity.getToName()
			, entity.getFromAddress()
			, entity.getFromName()
			, entity.getTitle()
			, entity.getContent()
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
	public MailsEntity insert(Integer user, MailsEntity entity) {
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
	public MailsEntity insert(MailsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailsEntity physicalUpdate(MailsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_update.sql");
		executeUpdate(sql, 
			entity.getStatus()
			, entity.getToAddress()
			, entity.getToName()
			, entity.getFromAddress()
			, entity.getFromName()
			, entity.getTitle()
			, entity.getContent()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getMailId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailsEntity update(Integer user, MailsEntity entity) {
		MailsEntity db = selectOnKey(entity.getMailId());
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
	public MailsEntity update(MailsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public MailsEntity save(Integer user, MailsEntity entity) {
		MailsEntity db = selectOnKey(entity.getMailId());
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
	public MailsEntity save(MailsEntity entity) {
		MailsEntity db = selectOnKey(entity.getMailId());
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
	public void physicalDelete(String mailId) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/MailsDao/MailsDao_delete.sql");
		executeUpdate(sql, mailId);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(MailsEntity entity) {
		physicalDelete(entity.getMailId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String mailId) {
		MailsEntity db = selectOnKey(mailId);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String mailId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, mailId);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, MailsEntity entity) {
		delete(user, entity.getMailId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(MailsEntity entity) {
		delete(entity.getMailId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String mailId) {
		MailsEntity db = physicalSelectOnKey(mailId);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String mailId) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, mailId);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, MailsEntity entity) {
		activation(user, entity.getMailId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(MailsEntity entity) {
		activation(entity.getMailId());

	}

}
