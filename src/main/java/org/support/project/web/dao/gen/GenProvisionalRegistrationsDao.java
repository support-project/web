package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.ProvisionalRegistrationsEntity;
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
 * 仮登録ユーザ
 */
@DI(instance=Instance.Singleton)
public class GenProvisionalRegistrationsDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenProvisionalRegistrationsDao get() {
		return Container.getComp(GenProvisionalRegistrationsDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<ProvisionalRegistrationsEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_physical_select_all.sql");
		return executeQueryList(sql, ProvisionalRegistrationsEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public ProvisionalRegistrationsEntity physicalSelectOnKey(String id) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, ProvisionalRegistrationsEntity.class, id);
	}
	/**
	 * 全て取得 
	 */
	public List<ProvisionalRegistrationsEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_select_all.sql");
		return executeQueryList(sql, ProvisionalRegistrationsEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public ProvisionalRegistrationsEntity selectOnKey(String id) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_select_on_key.sql");
		return executeQuerySingle(sql, ProvisionalRegistrationsEntity.class, id);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("PROVISIONAL_REGISTRATIONS");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProvisionalRegistrationsEntity rawPhysicalInsert(ProvisionalRegistrationsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getId()
			, entity.getUserKey()
			, entity.getUserName()
			, entity.getPassword()
			, entity.getSalt()
			, entity.getLocaleKey()
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
	public ProvisionalRegistrationsEntity physicalInsert(ProvisionalRegistrationsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_insert.sql");
		executeUpdate(sql, 
			entity.getId()
			, entity.getUserKey()
			, entity.getUserName()
			, entity.getPassword()
			, entity.getSalt()
			, entity.getLocaleKey()
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
	public ProvisionalRegistrationsEntity insert(Integer user, ProvisionalRegistrationsEntity entity) {
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
	public ProvisionalRegistrationsEntity insert(ProvisionalRegistrationsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProvisionalRegistrationsEntity physicalUpdate(ProvisionalRegistrationsEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_update.sql");
		executeUpdate(sql, 
			entity.getUserKey()
			, entity.getUserName()
			, entity.getPassword()
			, entity.getSalt()
			, entity.getLocaleKey()
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
	public ProvisionalRegistrationsEntity update(Integer user, ProvisionalRegistrationsEntity entity) {
		ProvisionalRegistrationsEntity db = selectOnKey(entity.getId());
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
	public ProvisionalRegistrationsEntity update(ProvisionalRegistrationsEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public ProvisionalRegistrationsEntity save(Integer user, ProvisionalRegistrationsEntity entity) {
		ProvisionalRegistrationsEntity db = selectOnKey(entity.getId());
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
	public ProvisionalRegistrationsEntity save(ProvisionalRegistrationsEntity entity) {
		ProvisionalRegistrationsEntity db = selectOnKey(entity.getId());
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
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/ProvisionalRegistrationsDao/ProvisionalRegistrationsDao_delete.sql");
		executeUpdate(sql, id);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(ProvisionalRegistrationsEntity entity) {
		physicalDelete(entity.getId());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String id) {
		ProvisionalRegistrationsEntity db = selectOnKey(id);
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
	public void delete(Integer user, ProvisionalRegistrationsEntity entity) {
		delete(user, entity.getId());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(ProvisionalRegistrationsEntity entity) {
		delete(entity.getId());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String id) {
		ProvisionalRegistrationsEntity db = physicalSelectOnKey(id);
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
	public void activation(Integer user, ProvisionalRegistrationsEntity entity) {
		activation(user, entity.getId());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(ProvisionalRegistrationsEntity entity) {
		activation(entity.getId());

	}

}
