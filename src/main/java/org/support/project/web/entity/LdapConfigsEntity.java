package org.support.project.web.entity;

import org.support.project.web.entity.gen.GenLdapConfigsEntity;

import java.util.List;
import java.util.Map;

import org.support.project.common.bean.ValidateError;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;

import java.sql.Timestamp;


/**
 * LDAP認証設定
 */
@DI(instance=Instance.Prototype)
public class LdapConfigsEntity extends GenLdapConfigsEntity {
	public static final int AUTH_TYPE_DB = 0;
	public static final int AUTH_TYPE_LDAP = 1;
	public static final int AUTH_TYPE_BOTH = 2;
	
	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static LdapConfigsEntity get() {
		return Container.getComp(LdapConfigsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public LdapConfigsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param systemName システム名
	 */

	public LdapConfigsEntity(String systemName) {
		super( systemName);
	}

}
