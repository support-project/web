package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.LocalesEntity;
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
 * ロケール
 */
@DI(instance=Instance.Singleton)
public class GenLocalesDao extends AbstractDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenLocalesDao get() {
		return Container.getComp(GenLocalesDao.class);
	}

	/**
	 * 全て取得(削除フラグを無視して取得) 
	 */
	public List<LocalesEntity> physicalSelectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_physical_select_all.sql");
		return executeQueryList(sql, LocalesEntity.class);
	}
	/**
	 * キーで1件取得(削除フラグを無視して取得) 
	 */
	public LocalesEntity physicalSelectOnKey(String key) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_physical_select_on_key.sql");
		return executeQuerySingle(sql, LocalesEntity.class, key);
	}
	/**
	 * 全て取得 
	 */
	public List<LocalesEntity> selectAll() { 
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_select_all.sql");
		return executeQueryList(sql, LocalesEntity.class);
	}
	/**
	 * キーで1件取得 
	 */
	public LocalesEntity selectOnKey(String key) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_select_on_key.sql");
		return executeQuerySingle(sql, LocalesEntity.class, key);
	}
	/**
	 * 行を一意に特定するIDを生成
	 */
	protected String createRowId() {
		return IDGen.get().gen("LOCALES");
	}
	/**
	 * 登録(データを生で操作/DBの採番機能のカラムも自分でセット) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LocalesEntity rawPhysicalInsert(LocalesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_raw_insert.sql");
		executeUpdate(sql, 
			entity.getKey()
			, entity.getLanguage()
			, entity.getCountry()
			, entity.getVariant()
			, entity.getDispName()
			, entity.getFlagIcon()
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
	public LocalesEntity physicalInsert(LocalesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_insert.sql");
		executeUpdate(sql, 
			entity.getKey()
			, entity.getLanguage()
			, entity.getCountry()
			, entity.getVariant()
			, entity.getDispName()
			, entity.getFlagIcon()
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
	public LocalesEntity insert(Integer user, LocalesEntity entity) {
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
	public LocalesEntity insert(LocalesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return insert(userId, entity);
	}
	/**
	 * 更新(データを生で操作) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LocalesEntity physicalUpdate(LocalesEntity entity) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_update.sql");
		executeUpdate(sql, 
			entity.getLanguage()
			, entity.getCountry()
			, entity.getVariant()
			, entity.getDispName()
			, entity.getFlagIcon()
			, entity.getRowId()
			, entity.getInsertUser()
			, entity.getInsertDatetime()
			, entity.getUpdateUser()
			, entity.getUpdateDatetime()
			, entity.getDeleteFlag()
			, entity.getKey()
		);
		return entity;
	}
	/**
	 * 更新(更新ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LocalesEntity update(Integer user, LocalesEntity entity) {
		LocalesEntity db = selectOnKey(entity.getKey());
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
	public LocalesEntity update(LocalesEntity entity) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer userId = (Integer) pool.getUser();
		return update(userId, entity);
	}
	/**
	 * 保存(ユーザを指定) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public LocalesEntity save(Integer user, LocalesEntity entity) {
		LocalesEntity db = selectOnKey(entity.getKey());
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
	public LocalesEntity save(LocalesEntity entity) {
		LocalesEntity db = selectOnKey(entity.getKey());
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
	public void physicalDelete(String key) {
		String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/LocalesDao/LocalesDao_delete.sql");
		executeUpdate(sql, key);
	}
	/**
	 * 削除(データを生で操作/物理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void physicalDelete(LocalesEntity entity) {
		physicalDelete(entity.getKey());

	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, String key) {
		LocalesEntity db = selectOnKey(key);
		db.setDeleteFlag(1);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(String key) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		delete(user, key);
	}
	/**
	 * 削除(削除ユーザを指定／論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(Integer user, LocalesEntity entity) {
		delete(user, entity.getKey());

	}
	/**
	 * 削除(論理削除があれば論理削除) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void delete(LocalesEntity entity) {
		delete(entity.getKey());

	}
	/**
	 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, String key) {
		LocalesEntity db = physicalSelectOnKey(key);
		db.setDeleteFlag(0);
		db.setUpdateUser(user);
		db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
		physicalUpdate(db);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(String key) {
		DBUserPool pool = Container.getComp(DBUserPool.class);
		Integer user = (Integer) pool.getUser();
		activation(user, key);
	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(Integer user, LocalesEntity entity) {
		activation(user, entity.getKey());

	}
	/**
	 * 復元(論理削除されていたものを有効化) 
	 */
	@Aspect(advice=org.support.project.ormapping.transaction.Transaction.class)
	public void activation(LocalesEntity entity) {
		activation(entity.getKey());

	}

}
