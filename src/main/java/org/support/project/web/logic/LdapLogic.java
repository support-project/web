package org.support.project.web.logic;

import java.io.IOException;

import org.apache.directory.api.ldap.model.cursor.Cursor;
import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.support.project.common.config.INT_FLAG;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.StringUtils;
import org.support.project.di.Container;
import org.support.project.web.bean.LdapInfo;
import org.support.project.web.entity.LdapConfigsEntity;

public class LdapLogic {
	/** ログ */
	private static Log LOG = LogFactory.getLog(LdapLogic.class);

	public static LdapLogic get() {
		return Container.getComp(LdapLogic.class);
	}

	/**
	 * Ldapを使った認証
	 * @param entity
	 * @param id
	 * @param password
	 * @return
	 * @throws IOException 
	 * @throws LdapException 
	 */
	public LdapInfo auth(LdapConfigsEntity entity, String id, String password) throws IOException, LdapException {
		LdapConnectionConfig config =new LdapConnectionConfig();
		config.setLdapHost(entity.getHost()); // LDAP Host
		config.setLdapPort(entity.getPort()); // LDAP Port
		if (entity.getUseSsl() != null && entity.getUseSsl().intValue() == INT_FLAG.ON.getValue()) {
			config.setUseSsl(true); // Use SSL
		} else if (entity.getUseTls() != null && entity.getUseTls().intValue() == INT_FLAG.ON.getValue()) {
			config.setUseTls(true); // USE TLS
		}
		LdapConnection conn = null;
		Cursor<Entry> cursor = null;
		try {
			conn = new LdapNetworkConnection(config);
			StringBuilder bindDn = new StringBuilder();
			bindDn.append(entity.getIdAttr()).append("=").append(id);
			if (StringUtils.isNotEmpty(entity.getBaseDn())) {
				bindDn.append(",").append(entity.getBaseDn());
			}
			conn.bind(bindDn.toString(), password);
			
			String base = entity.getBaseDn(); //Base DN
			StringBuilder filter = new StringBuilder();
			filter.append("(").append(entity.getIdAttr()).append("=").append(id).append(")");
			SearchScope scope = SearchScope.SUBTREE;
			cursor = conn.search(base, filter.toString(), scope);
			while (cursor.next()) {
				Entry entry = cursor.get();
				LdapInfo info = new LdapInfo();
				info.setId(entry.get(entity.getIdAttr()).getString());
				if (StringUtils.isNotEmpty(entity.getNameAttr())) {
					if (entry.get(entity.getNameAttr()) != null) {
						info.setName(entry.get(entity.getNameAttr()).getString());
					}
				}
				if (StringUtils.isNotEmpty(entity.getMailAttr())) {
					if (entry.get(entity.getMailAttr()) != null) {
						info.setMail(entry.get(entity.getMailAttr()).getString());
					}
				}
				
				if (StringUtils.isNotEmpty(entity.getAdminCheckFilter())) {
					String[] adminids = entity.getAdminCheckFilter().split(",");
					for (String string : adminids) {
						if (info.getId().equals(string.trim())) {
							info.setAdmin(true);
							break;
						}
					}
				}
				return info;
			}
			return null;
		} catch (LdapException | CursorException e) {
			//認証失敗
			return null;
		} finally {
			if (cursor != null) {
				cursor.close();
			}
			if (conn != null) {
				conn.unBind();
				conn.close();
			}
		}
	}
	
	

}
