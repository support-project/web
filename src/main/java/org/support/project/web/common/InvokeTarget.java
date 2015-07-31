package org.support.project.web.common;

import java.lang.reflect.Method;

import org.support.project.common.util.ObjectUtils;
import org.support.project.di.Container;

/**
 * 実行するターゲットのオブジェクト
 * 
 * @author Koda
 *
 */
public class InvokeTarget {
	/** 実行するクラス */
	private Class<?> targetClass;
	/** 実行するメソッド */
	private Method targetMethod;
	/** 実行ターゲット */
	private Object target;
	
	/** ターゲット検索で起点になったパッケージ名 */
	private String targetPackageName;
	/** ターゲットのパッケージ名からの、サブパッケージの名称 */
	private String subPackageName;
	/** ターゲットの検索の際に使ったサフィックス */
	private String classSuffix;


	/**
	 * コンストラクタ
	 * @param targetClass
	 * @param targetMethod
	 * @param targetPackageName
	 * @param classSuffix
	 */
	public InvokeTarget(Class<?> targetClass, Method targetMethod, String targetPackageName, String classSuffix) {
		super();
		this.targetClass = targetClass;
		this.targetMethod = targetMethod;
		//実行するオブジェクトのインスタンスをDIコンテナから取得
		//DIで、シングルトンなどの管理を行う
		this.target = Container.getComp(targetClass);

		this.targetPackageName = targetPackageName;
		
		String packageName = targetClass.getPackage().getName();
		if (!packageName.equals(targetPackageName) && packageName.length() > targetPackageName.length()) {
			subPackageName = packageName.substring(targetPackageName.length() + 1);
		}
		
		this.classSuffix = classSuffix;
	}
	
	public Class<?> getTargetClass() {
		return targetClass;
	}
	public Method getTargetMethod() {
		return targetMethod;
	}
	public Object getTarget() {
		return target;
	}
	public String getTargetPackageName() {
		return targetPackageName;
	}

	public String getSubPackageName() {
		return subPackageName;
	}
	public String getClassSuffix() {
		return classSuffix;
	}


	/**
	 * 処理を実行
	 * @param params パラメータ
	 * @return 実行結果
	 */
	public Object invoke(Object... params) {
		//処理を実施
		return ObjectUtils.invoke(target, targetMethod, params);
	}
	
	/**
	 * マルチスレッド時に同じInvokeTargetを実行するとスレッドセーフで無いので、コピーインスタンスを生成する
	 * @return
	 */
	public InvokeTarget copy() {
		InvokeTarget copy = new InvokeTarget(targetClass, targetMethod, targetPackageName, classSuffix);
		return copy;
	}
	
}
