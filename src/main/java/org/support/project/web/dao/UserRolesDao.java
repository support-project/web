package org.support.project.web.dao;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.dao.gen.GenUserRolesDao;

/**
 * ユーザの権限
 */
@DI(instance=Instance.Singleton)
public class UserRolesDao extends GenUserRolesDao {

	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/**
	 * インスタンス取得
	 * AOPに対応
	 * @return インスタンス
	 */
	public static UserRolesDao get() {
		return Container.getComp(UserRolesDao.class);
	}
	
	/**
	 * ユーザに紐づく権限を全て削除
	 * （物理削除）
	 * @param userId
	 */
	public void deleteOnUser(Integer userId) {
		String sql = "DELETE FROM USER_ROLES WHERE USER_ID = ?";
		super.executeUpdate(sql, userId);
	}



}
