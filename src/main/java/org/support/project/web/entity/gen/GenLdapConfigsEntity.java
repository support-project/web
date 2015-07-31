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
 * LDAP認証設定
 */
@DI(instance=Instance.Prototype)
public class GenLdapConfigsEntity implements Serializable {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;

	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static GenLdapConfigsEntity get() {
		return Container.getComp(GenLdapConfigsEntity.class);
	}

	/**
	 * コンストラクタ
	 */
	public GenLdapConfigsEntity() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param systemName システム名
	 */

	public GenLdapConfigsEntity(String systemName) {
		super();
		this.systemName = systemName;
	}
	/** システム名 */
	private String systemName;
	/** HOST */
	private String host;
	/** PORT */
	private Integer port;
	/** USE_SSL */
	private Integer useSsl;
	/** USE_TLS */
	private Integer useTls;
	/** BIND_DN */
	private String bindDn;
	/** BIND_PASSWORD */
	private String bindPassword;
	/** SALT */
	private String salt;
	/** BASE_DN */
	private String baseDn;
	/** FILTER */
	private String filter;
	/** ID_ATTR */
	private String idAttr;
	/** NAME_ATTR */
	private String nameAttr;
	/** MAIL_ATTR */
	private String mailAttr;
	/** ADMIN_CHECK_FILTER */
	private String adminCheckFilter;
	/** AUTH_TYPE	 0:DB認証,1:LDAP認証,2:DB認証+LDAP認証(LDAP優先) */
	private Integer authType;
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
	public GenLdapConfigsEntity setSystemName(String systemName) {
		this.systemName = systemName;
		return this;
	}

	/**
	 * HOST を取得する
	 */
	public String getHost() {
		return this.host;
	}
	/**
	 * HOST を設定する
	 * @param host HOST
	 */
	public GenLdapConfigsEntity setHost(String host) {
		this.host = host;
		return this;
	}

	/**
	 * PORT を取得する
	 */
	public Integer getPort() {
		return this.port;
	}
	/**
	 * PORT を設定する
	 * @param port PORT
	 */
	public GenLdapConfigsEntity setPort(Integer port) {
		this.port = port;
		return this;
	}

	/**
	 * USE_SSL を取得する
	 */
	public Integer getUseSsl() {
		return this.useSsl;
	}
	/**
	 * USE_SSL を設定する
	 * @param useSsl USE_SSL
	 */
	public GenLdapConfigsEntity setUseSsl(Integer useSsl) {
		this.useSsl = useSsl;
		return this;
	}

	/**
	 * USE_TLS を取得する
	 */
	public Integer getUseTls() {
		return this.useTls;
	}
	/**
	 * USE_TLS を設定する
	 * @param useTls USE_TLS
	 */
	public GenLdapConfigsEntity setUseTls(Integer useTls) {
		this.useTls = useTls;
		return this;
	}

	/**
	 * BIND_DN を取得する
	 */
	public String getBindDn() {
		return this.bindDn;
	}
	/**
	 * BIND_DN を設定する
	 * @param bindDn BIND_DN
	 */
	public GenLdapConfigsEntity setBindDn(String bindDn) {
		this.bindDn = bindDn;
		return this;
	}

	/**
	 * BIND_PASSWORD を取得する
	 */
	public String getBindPassword() {
		return this.bindPassword;
	}
	/**
	 * BIND_PASSWORD を設定する
	 * @param bindPassword BIND_PASSWORD
	 */
	public GenLdapConfigsEntity setBindPassword(String bindPassword) {
		this.bindPassword = bindPassword;
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
	public GenLdapConfigsEntity setSalt(String salt) {
		this.salt = salt;
		return this;
	}

	/**
	 * BASE_DN を取得する
	 */
	public String getBaseDn() {
		return this.baseDn;
	}
	/**
	 * BASE_DN を設定する
	 * @param baseDn BASE_DN
	 */
	public GenLdapConfigsEntity setBaseDn(String baseDn) {
		this.baseDn = baseDn;
		return this;
	}

	/**
	 * FILTER を取得する
	 */
	public String getFilter() {
		return this.filter;
	}
	/**
	 * FILTER を設定する
	 * @param filter FILTER
	 */
	public GenLdapConfigsEntity setFilter(String filter) {
		this.filter = filter;
		return this;
	}

	/**
	 * ID_ATTR を取得する
	 */
	public String getIdAttr() {
		return this.idAttr;
	}
	/**
	 * ID_ATTR を設定する
	 * @param idAttr ID_ATTR
	 */
	public GenLdapConfigsEntity setIdAttr(String idAttr) {
		this.idAttr = idAttr;
		return this;
	}

	/**
	 * NAME_ATTR を取得する
	 */
	public String getNameAttr() {
		return this.nameAttr;
	}
	/**
	 * NAME_ATTR を設定する
	 * @param nameAttr NAME_ATTR
	 */
	public GenLdapConfigsEntity setNameAttr(String nameAttr) {
		this.nameAttr = nameAttr;
		return this;
	}

	/**
	 * MAIL_ATTR を取得する
	 */
	public String getMailAttr() {
		return this.mailAttr;
	}
	/**
	 * MAIL_ATTR を設定する
	 * @param mailAttr MAIL_ATTR
	 */
	public GenLdapConfigsEntity setMailAttr(String mailAttr) {
		this.mailAttr = mailAttr;
		return this;
	}

	/**
	 * ADMIN_CHECK_FILTER を取得する
	 */
	public String getAdminCheckFilter() {
		return this.adminCheckFilter;
	}
	/**
	 * ADMIN_CHECK_FILTER を設定する
	 * @param adminCheckFilter ADMIN_CHECK_FILTER
	 */
	public GenLdapConfigsEntity setAdminCheckFilter(String adminCheckFilter) {
		this.adminCheckFilter = adminCheckFilter;
		return this;
	}

	/**
	 * AUTH_TYPE	 0:DB認証,1:LDAP認証,2:DB認証+LDAP認証(LDAP優先) を取得する
	 */
	public Integer getAuthType() {
		return this.authType;
	}
	/**
	 * AUTH_TYPE	 0:DB認証,1:LDAP認証,2:DB認証+LDAP認証(LDAP優先) を設定する
	 * @param authType AUTH_TYPE	 0:DB認証,1:LDAP認証,2:DB認証+LDAP認証(LDAP優先)
	 */
	public GenLdapConfigsEntity setAuthType(Integer authType) {
		this.authType = authType;
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
	public GenLdapConfigsEntity setRowId(String rowId) {
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
	public GenLdapConfigsEntity setInsertUser(Integer insertUser) {
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
	public GenLdapConfigsEntity setInsertDatetime(Timestamp insertDatetime) {
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
	public GenLdapConfigsEntity setUpdateUser(Integer updateUser) {
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
	public GenLdapConfigsEntity setUpdateDatetime(Timestamp updateDatetime) {
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
	public GenLdapConfigsEntity setDeleteFlag(Integer deleteFlag) {
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
	public boolean equalsOnKey(GenLdapConfigsEntity entity) {
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
		builder.append("useSsl = ").append(useSsl).append("\n");
		builder.append("useTls = ").append(useTls).append("\n");
		builder.append("bindDn = ").append(bindDn).append("\n");
		builder.append("bindPassword = ").append(bindPassword).append("\n");
		builder.append("salt = ").append(salt).append("\n");
		builder.append("baseDn = ").append(baseDn).append("\n");
		builder.append("filter = ").append(filter).append("\n");
		builder.append("idAttr = ").append(idAttr).append("\n");
		builder.append("nameAttr = ").append(nameAttr).append("\n");
		builder.append("mailAttr = ").append(mailAttr).append("\n");
		builder.append("adminCheckFilter = ").append(adminCheckFilter).append("\n");
		builder.append("authType = ").append(authType).append("\n");
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
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.useSsl, convLabelName("Use Ssl"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(this.useTls, convLabelName("Use Tls"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.bindDn, convLabelName("Bind Dn"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.bindPassword, convLabelName("Bind Password"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.salt, convLabelName("Salt"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.baseDn, convLabelName("Base Dn"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.baseDn, convLabelName("Base Dn"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.filter, convLabelName("Filter"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(this.idAttr, convLabelName("Id Attr"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.idAttr, convLabelName("Id Attr"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.nameAttr, convLabelName("Name Attr"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.mailAttr, convLabelName("Mail Attr"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(this.adminCheckFilter, convLabelName("Admin Check Filter"), 256);
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
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("useSsl"), convLabelName("Use Ssl"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.INTEGER);
		error = validator.validate(values.get("useTls"), convLabelName("Use Tls"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("bindDn"), convLabelName("Bind Dn"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("bindPassword"), convLabelName("Bind Password"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("salt"), convLabelName("Salt"), 1048);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("baseDn"), convLabelName("Base Dn"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("baseDn"), convLabelName("Base Dn"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("filter"), convLabelName("Filter"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.REQUIRED);
		error = validator.validate(values.get("idAttr"), convLabelName("Id Attr"));
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("idAttr"), convLabelName("Id Attr"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("nameAttr"), convLabelName("Name Attr"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("mailAttr"), convLabelName("Mail Attr"), 256);
		if (error != null) {
			errors.add(error);
		}
		validator = ValidatorFactory.getInstance(Validator.MAX_LENGTH);
		error = validator.validate(values.get("adminCheckFilter"), convLabelName("Admin Check Filter"), 256);
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
