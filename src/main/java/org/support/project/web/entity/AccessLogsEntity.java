package org.support.project.web.entity;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import org.support.project.common.bean.ValidateError;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.entity.gen.GenAccessLogsEntity;


/**
 * ACCESS_LOGS
 */
@DI(instance=Instance.Prototype)
public class AccessLogsEntity extends GenAccessLogsEntity {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static AccessLogsEntity get() {
		return Container.getComp(AccessLogsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public AccessLogsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param no NO
	 */

	public AccessLogsEntity(Long no) {
		super(no);
	}

}
