package org.support.project.web.entity;

import java.sql.Timestamp;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.entity.gen.GenRolesEntity;


/**
 * 権限
 */
@DI(instance=Instance.Prototype)
public class RolesEntity extends GenRolesEntity {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static RolesEntity get() {
		return Container.getComp(RolesEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public RolesEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param roleId 権限ID
	 */

	public RolesEntity(Integer roleId) {
		super( roleId);
	}

}
