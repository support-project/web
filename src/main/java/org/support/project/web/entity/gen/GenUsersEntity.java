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
 * ユーザ
 */
@DI(instance=Instance.Prototype)
public class GenUsersEntity implements Serializable {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenUsersEntity get() {
		return Container.getComp(GenUsersEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public GenUsersEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param userId ユーザID
	 */

	public GenUsersEntity(Integer userId) {
		super();
		this.userId = userId;
	}
	/** ユーザID */
	private Integer userId;
	/** ユーザKEY	 ユニーク */
	private String userKey;
	/** ユーザ名 */
	private String userName;
	/** パスワード	 ハッシュ(不可逆) */
	private String password;
	/** SALT */
	private String salt;
	/** ロケール */
	private String localeKey;
	/** メールアドレス */
	private String mailAddress;
	/** LDAP認証ユーザかどうか */
	private Integer authLdap;
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
	public GenUsersEntity setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * ユーザKEY	 ユニーク を取得する
	 */
	public String getUserKey() {
		return this.userKey;
	}
	/**
	 * ユーザKEY	 ユニーク を設定する
	 * @param userKey ユーザKEY	 ユニーク
	 */
	public GenUsersEntity setUserKey(String userKey) {
		this.userKey = userKey;
		return this;
	}

	/**
	 * ユーザ名 を取得する
	 */
	public String getUserName() {
		return this.userName;
	}
	/**
	 * ユーザ名 を設定する
	 * @param userName ユーザ名
	 */
	public GenUsersEntity setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * パスワード	 ハッシュ(不可逆) を取得する
	 */
	public String getPassword() {
		return this.password;
	}
	/**
	 * パスワード	 ハッシュ(不可逆) を設定する
	 * @param password パスワード	 ハッシュ(不可逆)
	 */
	public GenUsersEntity setPassword(String password) {
		this.password = password;
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
	public GenUsersEntity setSalt(String salt) {
		this.salt = salt;
		return this;
	}

	/**
	 * ロケール を取得する
	 */
	public String getLocaleKey() {
		return this.localeKey;
	}
	/**
	 * ロケール を設定する
	 * @param localeKey ロケール
	 */
	public GenUsersEntity setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
		return this;
	}

	/**
	 * メールアドレス を取得する
	 */
	public String getMailAddress() {
		return this.mailAddress;
	}
	/**
	 * メールアドレス を設定する
	 * @param mailAddress メールアドレス
	 */
	public GenUsersEntity setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
		return this;
	}

	/**
	 * LDAP認証ユーザかどうか を取得する
	 */
	public Integer getAuthLdap() {
		return this.authLdap;
	}
	/**
	 * LDAP認証ユーザかどうか を設定する
	 * @param authLdap LDAP認証ユーザかどうか
	 */
	public GenUsersEntity setAuthLdap(Integer authLdap) {
		this.authLdap = authLdap;
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
	public GenUsersEntity setRowId(String rowId) {
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
	public GenUsersEntity setInsertUser(Integer insertUser) {
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
	public GenUsersEntity setInsertDatetime(Timestamp insertDatetime) {
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
	public GenUsersEntity setUpdateUser(Integer updateUser) {
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
	public GenUsersEntity setUpdateDatetime(Timestamp updateDatetime) {
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
	public GenUsersEntity setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
		return this;
	}

	/**
	 * キーの値を取得 
	 */
	public Object[] getKeyValues() {
		Object[] keyValues = new Object[1];
		keyValues[0] = this.userId;
		return keyValues;
	}
	/**
	 * キーの値を設定 
	 * @param userId ユーザID
	 */
	public void setKeyValues(Integer userId) {
		this.userId = userId;
	}
	/**
	 * キーで比較 
	 */
	public boolean equalsOnKey(GenUsersEntity entity) {
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
		builder.append("userId = ").append(userId).append("\n");
		builder.append("userKey = ").append(userKey).append("\n");
		builder.append("userName = ").append(userName).append("\n");
		builder.append("password = ").append(password).append("\n");
		builder.append("salt = ").append(salt).append("\n");
		builder.append("localeKey = ").append(localeKey).append("\n");
		builder.append("mailAddress = ").append(mailAddress).append("\n");
		builder.append("authLdap = ").append(authLdap).append("\n");
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
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.userId, convLabelName("User Id"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.userKey, convLabelName("User Key"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.userKey, convLabelName("User Key"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.userName, convLabelName("User Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.userName, convLabelName("User Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.password, convLabelName("Password"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.password, convLabelName("Password"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.salt, convLabelName("Salt"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.localeKey, convLabelName("Locale Key"), 12);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.mailAddress, convLabelName("Mail Address"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.authLdap, convLabelName("Auth Ldap"));
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
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("userId"), convLabelName("User Id"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("userKey"), convLabelName("User Key"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("userKey"), convLabelName("User Key"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("userName"), convLabelName("User Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("userName"), convLabelName("User Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("password"), convLabelName("Password"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("password"), convLabelName("Password"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("salt"), convLabelName("Salt"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("localeKey"), convLabelName("Locale Key"), 12);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("mailAddress"), convLabelName("Mail Address"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("authLdap"), convLabelName("Auth Ldap"));
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
