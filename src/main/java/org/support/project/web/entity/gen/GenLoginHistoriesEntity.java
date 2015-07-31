package org.support.project.web.entity.gen;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import java.sql.Timestamp;



import org.support.project.common.bean.ValidateError;
import org.support.project.common.validate.Validator;
import org.support.project.common.validate.ValidatorFactory;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;

/**
 * ログイン履歴
 */
@DI(instance=Instance.Prototype)
public class GenLoginHistoriesEntity implements Serializable {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenLoginHistoriesEntity get() {
		return Container.getComp(GenLoginHistoriesEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public GenLoginHistoriesEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param loginCount ログイン番号
	 * @param userId ユーザID
	 */

	public GenLoginHistoriesEntity(Double loginCount, Integer userId) {
		super();
		this.loginCount = loginCount;
		this.userId = userId;
	}
	/** ユーザID */
	private Integer userId;
	/** ログイン番号 */
	private Double loginCount;
	/** ログイン日時 */
	private Timestamp lodinDateTime;
	/** IPアドレス */
	private String ipAddress;
	/** エージェント */
	private String userAgent;
	/** 行ID */
	private String rowId;
	/** 登録ユーザ */
	private Integer insertUser;
	/** 登録日時 */
	private Timestamp insertDatetime;
	/** 更新ユーザ */
	private Integer updateUser;
	/** 更新日時 */
	private Timestamp updateDatetime;
	/** 削除フラグ */
	private Integer deleteFlag;

	/**
	 * ユーザID を取得する
	 */
	public Integer getUserId() {
		return this.userId;
	}
	/**
	 * ユーザID を設定する
	 * @param userId ユーザID
	 */
	public GenLoginHistoriesEntity setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * ログイン番号 を取得する
	 */
	public Double getLoginCount() {
		return this.loginCount;
	}
	/**
	 * ログイン番号 を設定する
	 * @param loginCount ログイン番号
	 */
	public GenLoginHistoriesEntity setLoginCount(Double loginCount) {
		this.loginCount = loginCount;
		return this;
	}

	/**
	 * ログイン日時 を取得する
	 */
	public Timestamp getLodinDateTime() {
		return this.lodinDateTime;
	}
	/**
	 * ログイン日時 を設定する
	 * @param lodinDateTime ログイン日時
	 */
	public GenLoginHistoriesEntity setLodinDateTime(Timestamp lodinDateTime) {
		this.lodinDateTime = lodinDateTime;
		return this;
	}

	/**
	 * IPアドレス を取得する
	 */
	public String getIpAddress() {
		return this.ipAddress;
	}
	/**
	 * IPアドレス を設定する
	 * @param ipAddress IPアドレス
	 */
	public GenLoginHistoriesEntity setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		return this;
	}

	/**
	 * エージェント を取得する
	 */
	public String getUserAgent() {
		return this.userAgent;
	}
	/**
	 * エージェント を設定する
	 * @param userAgent エージェント
	 */
	public GenLoginHistoriesEntity setUserAgent(String userAgent) {
		this.userAgent = userAgent;
		return this;
	}

	/**
	 * 行ID を取得する
	 */
	public String getRowId() {
		return this.rowId;
	}
	/**
	 * 行ID を設定する
	 * @param rowId 行ID
	 */
	public GenLoginHistoriesEntity setRowId(String rowId) {
		this.rowId = rowId;
		return this;
	}

	/**
	 * 登録ユーザ を取得する
	 */
	public Integer getInsertUser() {
		return this.insertUser;
	}
	/**
	 * 登録ユーザ を設定する
	 * @param insertUser 登録ユーザ
	 */
	public GenLoginHistoriesEntity setInsertUser(Integer insertUser) {
		this.insertUser = insertUser;
		return this;
	}

	/**
	 * 登録日時 を取得する
	 */
	public Timestamp getInsertDatetime() {
		return this.insertDatetime;
	}
	/**
	 * 登録日時 を設定する
	 * @param insertDatetime 登録日時
	 */
	public GenLoginHistoriesEntity setInsertDatetime(Timestamp insertDatetime) {
		this.insertDatetime = insertDatetime;
		return this;
	}

	/**
	 * 更新ユーザ を取得する
	 */
	public Integer getUpdateUser() {
		return this.updateUser;
	}
	/**
	 * 更新ユーザ を設定する
	 * @param updateUser 更新ユーザ
	 */
	public GenLoginHistoriesEntity setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
		return this;
	}

	/**
	 * 更新日時 を取得する
	 */
	public Timestamp getUpdateDatetime() {
		return this.updateDatetime;
	}
	/**
	 * 更新日時 を設定する
	 * @param updateDatetime 更新日時
	 */
	public GenLoginHistoriesEntity setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
		return this;
	}

	/**
	 * 削除フラグ を取得する
	 */
	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}
	/**
	 * 削除フラグ を設定する
	 * @param deleteFlag 削除フラグ
	 */
	public GenLoginHistoriesEntity setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
		return this;
	}

	/**
	 * キーの値を取得 
	 */
	public Object[] getKeyValues() {
		Object[] keyValues = new Object[2];
		keyValues[0] = this.loginCount;
		keyValues[1] = this.userId;
		return keyValues;
	}
	/**
	 * キーの値を設定 
	 * @param loginCount ログイン番号
	 * @param userId ユーザID
	 */
	public void setKeyValues(Double loginCount, Integer userId) {
		this.loginCount = loginCount;
		this.userId = userId;
	}
	/**
	 * キーで比較 
	 */
	public boolean equalsOnKey(GenLoginHistoriesEntity entity) {
		Object[] keyValues1 = getKeyValues();
		Object[] keyValues2 = entity.getKeyValues();
		for (int i = 0; i < keyValues1.length; i++) {
			Object val1 = keyValues1[i];
			Object val2 = keyValues2[i];
			if (val1 == null && val2 != null) {
				return false;
			}
			if (val1 != null && val2 == null) {
				return false;
			}
			if (val1 != null && val2 != null) {
				if (!val1.equals(val2)) {
					return false;
				}
			}
			
		}
		return true;
	}
	/**
	 * ToString 
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("loginCount = ").append(loginCount).append("\n");
		builder.append("userId = ").append(userId).append("\n");
		builder.append("lodinDateTime = ").append(lodinDateTime).append("\n");
		builder.append("ipAddress = ").append(ipAddress).append("\n");
		builder.append("userAgent = ").append(userAgent).append("\n");
		builder.append("rowId = ").append(rowId).append("\n");
		builder.append("insertUser = ").append(insertUser).append("\n");
		builder.append("insertDatetime = ").append(insertDatetime).append("\n");
		builder.append("updateUser = ").append(updateUser).append("\n");
		builder.append("updateDatetime = ").append(updateDatetime).append("\n");
		builder.append("deleteFlag = ").append(deleteFlag).append("\n");
		return builder.toString();
	}
	/**
	 * 表示用の名称を変換 
	 */
	protected String convLabelName(String label) {
		return label;
	}
	/**
	 * validate 
	 */
	public List<ValidateError> validate() {
		List<ValidateError> errors = new ArrayList<>();
		Validator validator;
		ValidateError error;
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.userId, convLabelName("User Id"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.userId, convLabelName("User Id"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.loginCount, convLabelName("Login Count"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.lodinDateTime, convLabelName("Lodin Date Time"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.ipAddress, convLabelName("Ip Address"), 15);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.userAgent, convLabelName("User Agent"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.rowId, convLabelName("Row Id"), 64);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.insertUser, convLabelName("Insert User"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.updateUser, convLabelName("Update User"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.deleteFlag, convLabelName("Delete Flag"));
		if (error != null) {
			errors.add(error);
		}
		return errors;
	}
	/**
	 * validate 
	 */
	public List<ValidateError> validate(Map<String, String> values) {
		List<ValidateError> errors = new ArrayList<>();
		Validator validator;
		ValidateError error;
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("userId"), convLabelName("User Id"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("userId"), convLabelName("User Id"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("loginCount"), convLabelName("Login Count"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("lodinDateTime"), convLabelName("Lodin Date Time"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("ipAddress"), convLabelName("Ip Address"), 15);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("userAgent"), convLabelName("User Agent"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("rowId"), convLabelName("Row Id"), 64);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("insertUser"), convLabelName("Insert User"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("updateUser"), convLabelName("Update User"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("deleteFlag"), convLabelName("Delete Flag"));
		if (error != null) {
			errors.add(error);
		}
		return errors;
	}

}
