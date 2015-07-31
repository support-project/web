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
 * メール設定
 */
@DI(instance=Instance.Prototype)
public class GenMailConfigsEntity implements Serializable {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenMailConfigsEntity get() {
		return Container.getComp(GenMailConfigsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public GenMailConfigsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param systemName システム名
	 */

	public GenMailConfigsEntity(String systemName) {
		super();
		this.systemName = systemName;
	}
	/** システム名 */
	private String systemName;
	/** SMTP_HOST */
	private String host;
	/** SMTP_PORT */
	private Integer port;
	/** AUTH_TYPE */
	private Integer authType;
	/** SMTP_ID */
	private String smtpId;
	/** SMTP_PASSWORD	 暗号化（可逆） */
	private String smtpPassword;
	/** SALT */
	private String salt;
	/** 送信元 */
	private String fromAddress;
	/** 送信元名 */
	private String fromName;
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
	public GenMailConfigsEntity setSystemName(String systemName) {
		this.systemName = systemName;
		return this;
	}

	/**
	 * SMTP_HOST を取得する
	 */
	public String getHost() {
		return this.host;
	}
	/**
	 * SMTP_HOST を設定する
	 * @param host SMTP_HOST
	 */
	public GenMailConfigsEntity setHost(String host) {
		this.host = host;
		return this;
	}

	/**
	 * SMTP_PORT を取得する
	 */
	public Integer getPort() {
		return this.port;
	}
	/**
	 * SMTP_PORT を設定する
	 * @param port SMTP_PORT
	 */
	public GenMailConfigsEntity setPort(Integer port) {
		this.port = port;
		return this;
	}

	/**
	 * AUTH_TYPE を取得する
	 */
	public Integer getAuthType() {
		return this.authType;
	}
	/**
	 * AUTH_TYPE を設定する
	 * @param authType AUTH_TYPE
	 */
	public GenMailConfigsEntity setAuthType(Integer authType) {
		this.authType = authType;
		return this;
	}

	/**
	 * SMTP_ID を取得する
	 */
	public String getSmtpId() {
		return this.smtpId;
	}
	/**
	 * SMTP_ID を設定する
	 * @param smtpId SMTP_ID
	 */
	public GenMailConfigsEntity setSmtpId(String smtpId) {
		this.smtpId = smtpId;
		return this;
	}

	/**
	 * SMTP_PASSWORD	 暗号化（可逆） を取得する
	 */
	public String getSmtpPassword() {
		return this.smtpPassword;
	}
	/**
	 * SMTP_PASSWORD	 暗号化（可逆） を設定する
	 * @param smtpPassword SMTP_PASSWORD	 暗号化（可逆）
	 */
	public GenMailConfigsEntity setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
		return this;
	}

	/**
	 * SALT を取得する
	 */
	public String getSalt() {
		return this.salt;
	}
	/**
	 * SALT を設定する
	 * @param salt SALT
	 */
	public GenMailConfigsEntity setSalt(String salt) {
		this.salt = salt;
		return this;
	}

	/**
	 * 送信元 を取得する
	 */
	public String getFromAddress() {
		return this.fromAddress;
	}
	/**
	 * 送信元 を設定する
	 * @param fromAddress 送信元
	 */
	public GenMailConfigsEntity setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
		return this;
	}

	/**
	 * 送信元名 を取得する
	 */
	public String getFromName() {
		return this.fromName;
	}
	/**
	 * 送信元名 を設定する
	 * @param fromName 送信元名
	 */
	public GenMailConfigsEntity setFromName(String fromName) {
		this.fromName = fromName;
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
	public GenMailConfigsEntity setRowId(String rowId) {
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
	public GenMailConfigsEntity setInsertUser(Integer insertUser) {
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
	public GenMailConfigsEntity setInsertDatetime(Timestamp insertDatetime) {
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
	public GenMailConfigsEntity setUpdateUser(Integer updateUser) {
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
	public GenMailConfigsEntity setUpdateDatetime(Timestamp updateDatetime) {
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
	public GenMailConfigsEntity setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
		return this;
	}

	/**
	 * キーの値を取得 
	 */
	public Object[] getKeyValues() {
		Object[] keyValues = new Object[1];
		keyValues[0] = this.systemName;
		return keyValues;
	}
	/**
	 * キーの値を設定 
	 * @param systemName システム名
	 */
	public void setKeyValues(String systemName) {
		this.systemName = systemName;
	}
	/**
	 * キーで比較 
	 */
	public boolean equalsOnKey(GenMailConfigsEntity entity) {
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
		builder.append("systemName = ").append(systemName).append("\n");
		builder.append("host = ").append(host).append("\n");
		builder.append("port = ").append(port).append("\n");
		builder.append("authType = ").append(authType).append("\n");
		builder.append("smtpId = ").append(smtpId).append("\n");
		builder.append("smtpPassword = ").append(smtpPassword).append("\n");
		builder.append("salt = ").append(salt).append("\n");
		builder.append("fromAddress = ").append(fromAddress).append("\n");
		builder.append("fromName = ").append(fromName).append("\n");
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
		error = validator.validate(this.host, convLabelName("Host"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.host, convLabelName("Host"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.port, convLabelName("Port"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.port, convLabelName("Port"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.authType, convLabelName("Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.authType, convLabelName("Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.smtpId, convLabelName("Smtp Id"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.smtpPassword, convLabelName("Smtp Password"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.salt, convLabelName("Salt"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.fromAddress, convLabelName("From Address"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.fromName, convLabelName("From Name"), 256);
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
		error = validator.validate(values.get("host"), convLabelName("Host"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("host"), convLabelName("Host"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("port"), convLabelName("Port"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("port"), convLabelName("Port"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("authType"), convLabelName("Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("authType"), convLabelName("Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("smtpId"), convLabelName("Smtp Id"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("smtpPassword"), convLabelName("Smtp Password"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("salt"), convLabelName("Salt"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("fromAddress"), convLabelName("From Address"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("fromName"), convLabelName("From Name"), 256);
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
