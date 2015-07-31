
package org.support.project.web.logic;

import javax.servlet.http.HttpServletRequest;

import org.support.project.di.DI;
import org.support.project.web.bean.LoginedUser;
import org.support.project.web.exception.AuthenticateException;

//@DI(impl=org.support.project.transparent.base.logic.impl.DefaultAuthenticationLogicImpl.class)
public interface AuthenticationLogic<T extends LoginedUser> {
//	int RESULT_INSERT_SUCCESS = 0;
//	int RESULT_INSERT_ERROR = -1;
//	int RESULT_INSERT_DEPLCATE = -2;
//	
//	int RESULT_UPDATE_SUCCESS = 0;
//	int RESULT_UPDATE_ERROR = -1;
//	
//	int RESULT_DELETE_SUCCESS = 0;
//	int RESULT_DELETE_ERROR = -1;
	
	/**
	 * 認証
	 * @param userId
	 * @param password
	 * @return
	 * @throws AuthenticateException
	 */
	boolean auth(String userId, String password) throws AuthenticateException;
	/**
	 * ログインしているかどうか
	 * @param request
	 * @return
	 * @throws AuthenticateException
	 */
	boolean isLogined(HttpServletRequest request) throws AuthenticateException;
	/**
	 * セッションにログインしたユーザ情報を設定
	 * @param userId
	 * @param request
	 * @throws AuthenticateException
	 */
	void setSession(String userId, HttpServletRequest request) throws AuthenticateException;
	/**
	 * セッションに保持したユーザ情報を取得
	 * @param request
	 * @return
	 * @throws AuthenticateException
	 */
	T getSession(HttpServletRequest request) throws AuthenticateException;;
	/**
	 * 認可
	 * @param request
	 * @return
	 * @throws AuthenticateException
	 */
	boolean isAuthorize(HttpServletRequest request) throws AuthenticateException;
	
	/**
	 * セッションを破棄(ログアウト処理)
	 * @param request
	 * @throws AuthenticateException
	 */
	void clearSession(HttpServletRequest request) throws AuthenticateException;
	
	
//	String getLoginUserId(HttpServletRequest request) throws AuthenticateException;
	
//	List<String> getLoginRoleIds(HttpServletRequest request) throws AuthenticateException;
	
//	int insertUser(String userId, String password, String userName, String performer, Map<String, Object> params, String... roleIds) throws AuthenticateException;
//	int updateUser(String userId, String password, String userName, String performer, Map<String, Object> params, String... roleIds) throws AuthenticateException;
//	int deleteUser(String userId, String performer) throws Exception;
	
//	LoginedUser getUser(String userId) throws AuthenticateException;
//	List<LoginedUser> listUsers() throws AuthenticateException;
	
//	String encryptionPassword(String password) throws AuthenticateException;
}
