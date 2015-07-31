package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.ConfirmMailChangesEntity;
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
 * メールアドレス変更確認
 */
@DI(instance=Instance.Singleton)
public class GenConfirmMailChangesDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenConfirmMailChangesDao get() {
		return Container.getComp(GenConfirmMailChangesDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<ConfirmMailChangesEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_physical_select_all.sql");
		return executeQueryList(sql, ConfirmMailChangesEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public ConfirmMailChangesEntity physicalSelectOnKey(String id) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, ConfirmMailChangesEntity.class, id);
	}
	/**
	 * 全て取得 
	 */
	public List<ConfirmMailChangesEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_select_all.sql");
		return executeQueryList(sql, ConfirmMailChangesEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public ConfirmMailChangesEntity selectOnKey(String id) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_select_on_key.sql");
		return executeQuerySingle(sql, ConfirmMailChangesEntity.class, id);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("CONFIRM_MAIL_CHANGES");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ConfirmMailChangesEntity rawPhysicalInsert(ConfirmMailChangesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getId()
			, entity.getUserId()
			, entity.getMailAddress()
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
	public ConfirmMailChangesEntity physicalInsert(ConfirmMailChangesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_insert.sql");
		executeUpdate(sql, 
			entity.getId()
			, entity.getUserId()
			, entity.getMailAddress()
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
	public ConfirmMailChangesEntity insert(Integer user, ConfirmMailChangesEntity entity) {
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
	public ConfirmMailChangesEntity insert(ConfirmMailChangesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ConfirmMailChangesEntity physicalUpdate(ConfirmMailChangesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_update.sql");
		executeUpdate(sql, 
			entity.getUserId()
			, entity.getMailAddress()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getId()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ConfirmMailChangesEntity update(Integer user, ConfirmMailChangesEntity entity) {
		ConfirmMailChangesEntity db = selectOnKey(entity.getId());
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
	public ConfirmMailChangesEntity update(ConfirmMailChangesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ConfirmMailChangesEntity save(Integer user, ConfirmMailChangesEntity entity) {
		ConfirmMailChangesEntity db = selectOnKey(entity.getId());
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
	public ConfirmMailChangesEntity save(ConfirmMailChangesEntity entity) {
		ConfirmMailChangesEntity db = selectOnKey(entity.getId());
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
	public void physicalDelete(String id) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ConfirmMailChangesDao/ConfirmMailChangesDao_delete.sql");
		executeUpdate(sql, id);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(ConfirmMailChangesEntity entity) {
		physicalDelete(entity.getId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String id) {
		ConfirmMailChangesEntity db = selectOnKey(id);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String id) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, id);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, ConfirmMailChangesEntity entity) {
		delete(user, entity.getId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(ConfirmMailChangesEntity entity) {
		delete(entity.getId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String id) {
		ConfirmMailChangesEntity db = physicalSelectOnKey(id);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String id) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, id);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, ConfirmMailChangesEntity entity) {
		activation(user, entity.getId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(ConfirmMailChangesEntity entity) {
		activation(entity.getId());

	}

}
