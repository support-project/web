package org.support.project.web.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.support.project.web.config.CommonWebParameter;
import org.support.project.web.entity.GroupsEntity;
import org.support.project.web.entity.RolesEntity;
import org.support.project.web.entity.UsersEntity;

/**
 * ログインしたユーザのセッションに保持する情報
 * @author koda
 *
 */
public class LoginedUser implements Serializable {
	/** シリアルバージョン */
	private static final long serialVersionUID = 1L;

	/** ログインしたユーザの情報 */
	private UsersEntity loginUser;
	
	/** ログインしたユーザが持つ権限 */
	private List<RolesEntity> roles;
	
	/** ログインしたユーザが所属するグループ */
	private List<GroupsEntity> groups;

	/** ログインしたユーザが利用しているロケール */
	private Locale locale;
	
	/**
	 * ユーザIDを取得
	 * @return
	 */
	public Integer getUserId() {
		if (loginUser != null) {
			return loginUser.getUserId();
		}
		return Integer.MIN_VALUE;
	}
	
	
	/**
	 * 管理者かどうか
	 * @return
	 */
	public boolean isAdmin() {
		if (roles != null) {
			for (RolesEntity roleId : roles) {
				if (roleId.getRoleKey().equals(CommonWebParameter.ROLE_ADMIN)) {
					return true;
				}
	 		}
		}
		return false;
	}
	/**
	 * 指定のロールを持っているかチェック
	 * @param roleArray
	 * @return
	 */
	public boolean haveRole(String... roleArray) {
		if (roles != null) {
			for (RolesEntity roleId : roles) {
				for (String role : roleArray) {
					if (roleId.getRoleKey().equals(role)) {
						return true;
					}
				}
	 		}
		}
		return false;
	}
	
	
	
	/**
	 * @return loginUser
	 */
	public UsersEntity getLoginUser() {
		loginUser.setPassword(""); //セッションに持つ場合、パスワードはクリアすること
		return loginUser;
	}

	/**
	 * @param loginUser セットする loginUser
	 */
	public void setLoginUser(UsersEntity loginUser) {
		loginUser.setPassword(""); //セッションに持つ場合、パスワードはクリアすること
		this.loginUser = loginUser;
	}

	/**
	 * @return roles
	 */
	public List<RolesEntity> getRoles() {
		return roles;
	}

	/**
	 * @param roles セットする roles
	 */
	public void setRoles(List<RolesEntity> roles) {
		this.roles = roles;
	}

	/**
	 * @return groups
	 */
	public List<GroupsEntity> getGroups() {
		return groups;
	}

	/**
	 * @param groups セットする groups
	 */
	public void setGroups(List<GroupsEntity> groups) {
		this.groups = groups;
	}


	public Locale getLocale() {
		return locale;
	}


	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	
}
