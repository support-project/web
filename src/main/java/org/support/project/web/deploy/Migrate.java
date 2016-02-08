package org.support.project.web.deploy;

public interface Migrate {
	
	/**
	 * マイグレーション実行
	 * @return
	 * @throws Exception
	 */
	boolean doMigrate() throws Exception;
	
	/**
	 * バージョンを指定
	 * @return
	 */
	Double getVersion();
}
