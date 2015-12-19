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
 * ユーザ設定
 */
@DI(instance=Instance.Prototype)
public class GenUserConfigsEntity implements Serializable {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenUserConfigsEntity get() {
		return Container.getComp(GenUserConfigsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public GenUserConfigsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param configName コンフィグ名
	 * @param systemName システム名
	 * @param userId ユーザID
	 */

	public GenUserConfigsEntity(String configName, String systemName, Integer userId) {
		super();
		this.configName = configName;
		this.systemName = systemName;
		this.userId = userId;
	}
	/** システム名 */
	private String systemName;
	/** ユーザID */
	private Integer userId;
	/** コンフィグ名 */
	private String configName;
	/** コンフィグ値 */
	private String configValue;
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
	 * システム名 を取得する
	 */
	public String getSystemName() {
		return this.systemName;
	}
	/**
	 * システム名 を設定する
	 * @param systemName システム名
	 */
	public GenUserConfigsEntity setSystemName(String systemName) {
		this.systemName = systemName;
		return this;
	}

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
	public GenUserConfigsEntity setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * コンフィグ名 を取得する
	 */
	public String getConfigName() {
		return this.configName;
	}
	/**
	 * コンフィグ名 を設定する
	 * @param configName コンフィグ名
	 */
	public GenUserConfigsEntity setConfigName(String configName) {
		this.configName = configName;
		return this;
	}

	/**
	 * コンフィグ値 を取得する
	 */
	public String getConfigValue() {
		return this.configValue;
	}
	/**
	 * コンフィグ値 を設定する
	 * @param configValue コンフィグ値
	 */
	public GenUserConfigsEntity setConfigValue(String configValue) {
		this.configValue = configValue;
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
	public GenUserConfigsEntity setRowId(String rowId) {
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
	public GenUserConfigsEntity setInsertUser(Integer insertUser) {
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
	public GenUserConfigsEntity setInsertDatetime(Timestamp insertDatetime) {
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
	public GenUserConfigsEntity setUpdateUser(Integer updateUser) {
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
	public GenUserConfigsEntity setUpdateDatetime(Timestamp updateDatetime) {
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
	public GenUserConfigsEntity setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
		return this;
	}

	/**
	 * キーの値を取得 
	 */
	public Object[] getKeyValues() {
		Object[] keyValues = new Object[3];
		keyValues[0] = this.configName;
		keyValues[1] = this.systemName;
		keyValues[2] = this.userId;
		return keyValues;
	}
	/**
	 * キーの値を設定 
	 * @param configName コンフィグ名
	 * @param systemName システム名
	 * @param userId ユーザID
	 */
	public void setKeyValues(String configName, String systemName, Integer userId) {
		this.configName = configName;
		this.systemName = systemName;
		this.userId = userId;
	}
	/**
	 * キーで比較 
	 */
	public boolean equalsOnKey(GenUserConfigsEntity entity) {
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
		builder.append("configName = ").append(configName).append("\n");
		builder.append("systemName = ").append(systemName).append("\n");
		builder.append("userId = ").append(userId).append("\n");
		builder.append("configValue = ").append(configValue).append("\n");
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
		error = validator.validate(this.systemName, convLabelName("System Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.systemName, convLabelName("System Name"), 64);
		if (error != null) {
			errors.add(error);
		}
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
		error = validator.validate(this.configName, convLabelName("Config Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.configName, convLabelName("Config Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.configValue, convLabelName("Config Value"), 1024);
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
		error = validator.validate(values.get("systemName"), convLabelName("System Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("systemName"), convLabelName("System Name"), 64);
		if (error != null) {
			errors.add(error);
		}
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
		error = validator.validate(values.get("configName"), convLabelName("Config Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("configName"), convLabelName("Config Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("configValue"), convLabelName("Config Value"), 1024);
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
