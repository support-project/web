package org.support.project.web.websocket;

import javax.websocket.Session;

import org.support.project.web.bean.LoginedUser;

public abstract class AbstractEndpoint {
	
	public abstract void onOpen(Session session) throws Exception;
	public abstract void onClose(Session session) throws Exception;
	public abstract void onMessage(String text) throws Exception;
	public abstract void onError(Throwable t);

	/**
	 * WebSocketにアクセスしているユーザが管理者かどうかチェック
	 * @param session
	 * @return
	 */
	protected boolean isAdmin(Session session) {
		 if (session.getUserProperties().containsKey(EndpointConfigurator.LOCALE_KEY)) {
			LoginedUser loginuser = (LoginedUser) session.getUserProperties().get(EndpointConfigurator.LOGIN_USER_KEY);
			if (loginuser.isAdmin()) {
				return true;
			}
		}
		return false;
	}

	
}
