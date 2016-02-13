package org.support.project.web.config;

import java.util.ArrayList;
import java.util.List;

import org.support.project.common.config.ConfigLoader;
import org.support.project.common.util.StringUtils;
import org.support.project.web.bean.LabelValue;

public class AppConfig extends org.support.project.common.config.AppConfig {
	public static AppConfig get() {
		if (appConfig == null) {
			appConfig = ConfigLoader.load(AppConfig.APP_CONFIG, AppConfig.class);
		}
		return appConfig;
	}
	private static AppConfig appConfig = null;
	
	private static final int DEFAULT_HASH_ITERATIONS = 100;
	
	private String tmpPath;
	private int uploadMaxMBSize;
	private boolean convTmpPath = false;
	
	private String migratePackage;
	
	/** HASH_ITERATIONS */
	private Integer hashIterations = DEFAULT_HASH_ITERATIONS;
	/** HASH_SIZE_BITS */
//	private Integer hashSizeBits;
	
	private static String webRealPath = "";
	
	private List<LabelValue> languages = new ArrayList<>();
	
	/**
	 * @return the tmpPath
	 */
	public String getTmpPath() {
		if (StringUtils.isEmpty(tmpPath)) {
			return "";
		}
		if (!convTmpPath) {
			String path = tmpPath;
			tmpPath = convPath(path);
			convTmpPath = true;
		}
		return tmpPath;
	}

	/**
	 * @param tmpPath the tmpPath to set
	 */
	public void setTmpPath(String tmpPath) {
		this.tmpPath = tmpPath;
	}

	/**
	 * @return the uploadMaxMBSize
	 */
	public int getUploadMaxMBSize() {
		return uploadMaxMBSize;
	}

	/**
	 * @param uploadMaxMBSize the uploadMaxMBSize to set
	 */
	public void setUploadMaxMBSize(int uploadMaxMBSize) {
		this.uploadMaxMBSize = uploadMaxMBSize;
	}


	/**
	 * @return the hashIterations
	 */
	public Integer getHashIterations() {
		return hashIterations;
	}

	/**
	 * @param hashIterations the hashIterations to set
	 */
	public void setHashIterations(Integer hashIterations) {
		this.hashIterations = hashIterations;
	}

	/**
	 * @return the webRealPath
	 */
	public String getWebRealPath() {
		return webRealPath;
	}

	/**
	 * @param webRealPath the webRealPath to set
	 */
	public static void setWebRealPath(String webRealPath) {
		AppConfig.webRealPath = webRealPath;
	}
	
	/**
	 * @return the languages
	 */
	public List<LabelValue> getLanguages() {
		return languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(List<LabelValue> languages) {
		this.languages = languages;
	}

	/**
	 * @return the migratePackage
	 */
	public String getMigratePackage() {
		return migratePackage;
	}

	/**
	 * @param migratePackage the migratePackage to set
	 */
	public void setMigratePackage(String migratePackage) {
		this.migratePackage = migratePackage;
	}
	
}
