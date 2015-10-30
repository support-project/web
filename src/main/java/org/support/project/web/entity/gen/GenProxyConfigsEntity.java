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
 * プロキシ設定
 */
@DI(instance=Instance.Prototype)
public class GenProxyConfigsEntity implements Serializable {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenProxyConfigsEntity get() {
		return Container.getComp(GenProxyConfigsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public GenProxyConfigsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param systemName システム名
	 */

	public GenProxyConfigsEntity(String systemName) {
		super();
		this.systemName = systemName;
	}
	/** システム名 */
	private String systemName;
	/** [Proxy]ホスト名 */
	private String proxyHostName;
	/** [Proxy]ポート番号 */
	private Integer proxyPortNo;
	/** [Proxy-Auth]認証タイプ */
	private Integer proxyAuthType;
	/** [Proxy-Auth]認証ユーザID */
	private String proxyAuthUserId;
	/** [Proxy-Auth]認証パスワード */
	private String proxyAuthPassword;
	/** [Proxy-Auth]認証SALT */
	private String proxyAuthSalt;
	/** [Proxy-Auth-NTLM]認証PC名 */
	private String proxyAuthPcName;
	/** [Auth-NTLM]認証ドメイン */
	private String proxyAuthDomain;
	/** [Web]SSL証明書チェック */
	private Integer thirdPartyCertificate;
	/** [Web]接続確認用URL */
	private String testUrl;
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
	public GenProxyConfigsEntity setSystemName(String systemName) {
		this.systemName = systemName;
		return this;
	}

	/**
	 * [Proxy]ホスト名 を取得する
	 */
	public String getProxyHostName() {
		return this.proxyHostName;
	}
	/**
	 * [Proxy]ホスト名 を設定する
	 * @param proxyHostName [Proxy]ホスト名
	 */
	public GenProxyConfigsEntity setProxyHostName(String proxyHostName) {
		this.proxyHostName = proxyHostName;
		return this;
	}

	/**
	 * [Proxy]ポート番号 を取得する
	 */
	public Integer getProxyPortNo() {
		return this.proxyPortNo;
	}
	/**
	 * [Proxy]ポート番号 を設定する
	 * @param proxyPortNo [Proxy]ポート番号
	 */
	public GenProxyConfigsEntity setProxyPortNo(Integer proxyPortNo) {
		this.proxyPortNo = proxyPortNo;
		return this;
	}

	/**
	 * [Proxy-Auth]認証タイプ を取得する
	 */
	public Integer getProxyAuthType() {
		return this.proxyAuthType;
	}
	/**
	 * [Proxy-Auth]認証タイプ を設定する
	 * @param proxyAuthType [Proxy-Auth]認証タイプ
	 */
	public GenProxyConfigsEntity setProxyAuthType(Integer proxyAuthType) {
		this.proxyAuthType = proxyAuthType;
		return this;
	}

	/**
	 * [Proxy-Auth]認証ユーザID を取得する
	 */
	public String getProxyAuthUserId() {
		return this.proxyAuthUserId;
	}
	/**
	 * [Proxy-Auth]認証ユーザID を設定する
	 * @param proxyAuthUserId [Proxy-Auth]認証ユーザID
	 */
	public GenProxyConfigsEntity setProxyAuthUserId(String proxyAuthUserId) {
		this.proxyAuthUserId = proxyAuthUserId;
		return this;
	}

	/**
	 * [Proxy-Auth]認証パスワード を取得する
	 */
	public String getProxyAuthPassword() {
		return this.proxyAuthPassword;
	}
	/**
	 * [Proxy-Auth]認証パスワード を設定する
	 * @param proxyAuthPassword [Proxy-Auth]認証パスワード
	 */
	public GenProxyConfigsEntity setProxyAuthPassword(String proxyAuthPassword) {
		this.proxyAuthPassword = proxyAuthPassword;
		return this;
	}

	/**
	 * [Proxy-Auth]認証SALT を取得する
	 */
	public String getProxyAuthSalt() {
		return this.proxyAuthSalt;
	}
	/**
	 * [Proxy-Auth]認証SALT を設定する
	 * @param proxyAuthSalt [Proxy-Auth]認証SALT
	 */
	public GenProxyConfigsEntity setProxyAuthSalt(String proxyAuthSalt) {
		this.proxyAuthSalt = proxyAuthSalt;
		return this;
	}

	/**
	 * [Proxy-Auth-NTLM]認証PC名 を取得する
	 */
	public String getProxyAuthPcName() {
		return this.proxyAuthPcName;
	}
	/**
	 * [Proxy-Auth-NTLM]認証PC名 を設定する
	 * @param proxyAuthPcName [Proxy-Auth-NTLM]認証PC名
	 */
	public GenProxyConfigsEntity setProxyAuthPcName(String proxyAuthPcName) {
		this.proxyAuthPcName = proxyAuthPcName;
		return this;
	}

	/**
	 * [Auth-NTLM]認証ドメイン を取得する
	 */
	public String getProxyAuthDomain() {
		return this.proxyAuthDomain;
	}
	/**
	 * [Auth-NTLM]認証ドメイン を設定する
	 * @param proxyAuthDomain [Auth-NTLM]認証ドメイン
	 */
	public GenProxyConfigsEntity setProxyAuthDomain(String proxyAuthDomain) {
		this.proxyAuthDomain = proxyAuthDomain;
		return this;
	}

	/**
	 * [Web]SSL証明書チェック を取得する
	 */
	public Integer getThirdPartyCertificate() {
		return this.thirdPartyCertificate;
	}
	/**
	 * [Web]SSL証明書チェック を設定する
	 * @param thirdPartyCertificate [Web]SSL証明書チェック
	 */
	public GenProxyConfigsEntity setThirdPartyCertificate(Integer thirdPartyCertificate) {
		this.thirdPartyCertificate = thirdPartyCertificate;
		return this;
	}

	/**
	 * [Web]接続確認用URL を取得する
	 */
	public String getTestUrl() {
		return this.testUrl;
	}
	/**
	 * [Web]接続確認用URL を設定する
	 * @param testUrl [Web]接続確認用URL
	 */
	public GenProxyConfigsEntity setTestUrl(String testUrl) {
		this.testUrl = testUrl;
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
	public GenProxyConfigsEntity setRowId(String rowId) {
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
	public GenProxyConfigsEntity setInsertUser(Integer insertUser) {
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
	public GenProxyConfigsEntity setInsertDatetime(Timestamp insertDatetime) {
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
	public GenProxyConfigsEntity setUpdateUser(Integer updateUser) {
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
	public GenProxyConfigsEntity setUpdateDatetime(Timestamp updateDatetime) {
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
	public GenProxyConfigsEntity setDeleteFlag(Integer deleteFlag) {
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
	public boolean equalsOnKey(GenProxyConfigsEntity entity) {
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
		builder.append("proxyHostName = ").append(proxyHostName).append("\n");
		builder.append("proxyPortNo = ").append(proxyPortNo).append("\n");
		builder.append("proxyAuthType = ").append(proxyAuthType).append("\n");
		builder.append("proxyAuthUserId = ").append(proxyAuthUserId).append("\n");
		builder.append("proxyAuthPassword = ").append(proxyAuthPassword).append("\n");
		builder.append("proxyAuthSalt = ").append(proxyAuthSalt).append("\n");
		builder.append("proxyAuthPcName = ").append(proxyAuthPcName).append("\n");
		builder.append("proxyAuthDomain = ").append(proxyAuthDomain).append("\n");
		builder.append("thirdPartyCertificate = ").append(thirdPartyCertificate).append("\n");
		builder.append("testUrl = ").append(testUrl).append("\n");
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
		error = validator.validate(this.proxyHostName, convLabelName("Proxy Host Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.proxyHostName, convLabelName("Proxy Host Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.proxyPortNo, convLabelName("Proxy Port No"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.proxyPortNo, convLabelName("Proxy Port No"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.proxyAuthType, convLabelName("Proxy Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.proxyAuthType, convLabelName("Proxy Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.proxyAuthUserId, convLabelName("Proxy Auth User Id"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.proxyAuthPassword, convLabelName("Proxy Auth Password"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.proxyAuthSalt, convLabelName("Proxy Auth Salt"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.proxyAuthPcName, convLabelName("Proxy Auth Pc Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.proxyAuthDomain, convLabelName("Proxy Auth Domain"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.thirdPartyCertificate, convLabelName("Third Party Certificate"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.testUrl, convLabelName("Test Url"), 256);
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
		error = validator.validate(values.get("proxyHostName"), convLabelName("Proxy Host Name"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("proxyHostName"), convLabelName("Proxy Host Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("proxyPortNo"), convLabelName("Proxy Port No"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("proxyPortNo"), convLabelName("Proxy Port No"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("proxyAuthType"), convLabelName("Proxy Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("proxyAuthType"), convLabelName("Proxy Auth Type"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("proxyAuthUserId"), convLabelName("Proxy Auth User Id"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("proxyAuthPassword"), convLabelName("Proxy Auth Password"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("proxyAuthSalt"), convLabelName("Proxy Auth Salt"), 1024);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("proxyAuthPcName"), convLabelName("Proxy Auth Pc Name"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("proxyAuthDomain"), convLabelName("Proxy Auth Domain"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("thirdPartyCertificate"), convLabelName("Third Party Certificate"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("testUrl"), convLabelName("Test Url"), 256);
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
