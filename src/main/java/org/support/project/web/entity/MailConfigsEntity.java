package org.support.project.web.entity;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import org.support.project.common.bean.ValidateError;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.entity.gen.GenMailConfigsEntity;


/**
 * メール設定
 */
@DI(instance=Instance.Prototype)
public class MailConfigsEntity extends GenMailConfigsEntity {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static MailConfigsEntity get() {
		return Container.getComp(MailConfigsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public MailConfigsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param systemName システム名
	 */

	public MailConfigsEntity(String systemName) {
		super( systemName);
	}

}
