package org.support.project.web.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.support.project.common.classanalysis.ClassSearch;
import org.support.project.common.classanalysis.impl.ClassSearchImpl;
import org.support.project.common.exception.SystemException;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.StringUtils;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.config.HttpMethod;
import org.support.project.web.control.service.Delete;
import org.support.project.web.control.service.Get;
import org.support.project.web.control.service.Post;
import org.support.project.web.control.service.Put;

@DI(instance = Instance.Singleton)
public class InvokeSearch {
    /** ログ */
    private static Log log = LogFactory.getLog(InvokeSearch.class);

    /** 文字列に対するターゲット */
    private Map<String, InvokeTarget> invokeGetTargets;
    private Map<String, InvokeTarget> invokePostTargets;
    private Map<String, InvokeTarget> invokePutTargets;
    private Map<String, InvokeTarget> invokeDeleteTargets;

    /**
     * コンストラクタ
     */
    public InvokeSearch() {
        super();
        invokeGetTargets = new HashMap<>();
        invokePostTargets = new HashMap<>();
        invokePutTargets = new HashMap<>();
        invokeDeleteTargets = new HashMap<>();
    }

    /**
     * 指定のパッケージ内のクラスを読み込み、 パス文字列でアクセスした際に、実行するターゲットを追加する
     * 
     * @param targetPackageName ターゲットのパッケージ
     * @param classSuffix クラスのサフィックス
     */
    public void addTarget(String targetPackageName, String classSuffix) {
        this.addTarget(targetPackageName, classSuffix, true);
    }

    /**
     * 指定のパッケージ内のクラスを読み込み、 パス文字列でアクセスした際に、実行するターゲットを追加する
     * 
     * @param targetPackageName ターゲットのパッケージ
     * @param classSuffix クラスのサフィックス
     * @param subpackages サブパッケージを対象にするか
     */
    public void addTarget(String targetPackageName, String classSuffix, boolean subpackages) {
        ClassSearch classSearch = new ClassSearchImpl();
        Class<?>[] classes = classSearch.classSearch(targetPackageName, subpackages);
        if (classes != null) {
            for (Class<?> class1 : classes) {
                if (class1.getName().endsWith(classSuffix)) {
                    // サフィックスが同じものみを処理する
                    int mod = class1.getModifiers();
                    if (!class1.isInterface() && !Modifier.isAbstract(mod)) {
                        // インタフェースとアブストラクトクラスは除外
                        addTarget(class1, targetPackageName, classSuffix);
                    }
                }
            }
        }
    }

    /**
     * 指定のクラスを、実行ターゲットに追加する
     * 
     * @param class1 クラス
     * @param targetPackageName 検索するパッケージ名
     * @param classSuffix サフィックス
     */
    private void addTarget(Class<?> class1, String targetPackageName, String classSuffix) {
        // 以下の規則で、実行ターゲットを登録する
        // {subpackage}.{Classname(Suffixを除外)}/{methodName}
        StringBuilder builder = new StringBuilder();
        String packageName = class1.getPackage().getName();
        if (packageName.length() > targetPackageName.length() && packageName.startsWith(targetPackageName)) {
            packageName = packageName.substring(targetPackageName.length() + 1);
            builder.append(packageName);
            builder.append(".");
        }
        String className = class1.getName().substring(class1.getPackage().getName().length() + 1, class1.getName().length() - classSuffix.length());
        builder.append(className);

        Method[] methods = class1.getMethods();
        if (methods != null) {
            for (Method method : methods) {
                // Get/Post/Put/Delete が指定されていないものは対象外とする
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Get) {
                        Get get = (Get) annotation;
                        addGetTarget(class1, method, targetPackageName, classSuffix, builder.toString(), get);
                    }
                    if (annotation instanceof Post) {
                        Post post = (Post) annotation;
                        addPostTarget(class1, method, targetPackageName, classSuffix, builder.toString(), post);
                    }
                    if (annotation instanceof Put) {
                        Put put = (Put) annotation;
                        addPutTarget(class1, method, targetPackageName, classSuffix, builder.toString(), put);
                    }
                    if (annotation instanceof Delete) {
                        Delete delete = (Delete) annotation;
                        addDeleteTarget(class1, method, targetPackageName, classSuffix, builder.toString(), delete);
                    }

                }
            }
        }
    }

    private void addDeleteTarget(Class<?> class1, Method method, String targetPackageName, String classSuffix, String call, Delete delete) {
        String path = delete.path();
        addTarget(class1, method, targetPackageName, classSuffix, call, path, invokeDeleteTargets);
    }

    private void addPutTarget(Class<?> class1, Method method, String targetPackageName, String classSuffix, String call, Put put) {
        String path = put.path();
        addTarget(class1, method, targetPackageName, classSuffix, call, path, invokePutTargets);
    }

    private void addPostTarget(Class<?> class1, Method method, String targetPackageName, String classSuffix, String call, Post post) {
        String path = post.path();
        addTarget(class1, method, targetPackageName, classSuffix, call, path, invokePostTargets);
    }

    private void addGetTarget(Class<?> class1, Method method, String targetPackageName, String classSuffix, String call, Get get) {
        String path = get.path();
        addTarget(class1, method, targetPackageName, classSuffix, call, path, invokeGetTargets);
    }

    private void addTarget(Class<?> class1, Method method, String targetPackageName, String classSuffix, String call, String path,
            Map<String, InvokeTarget> invokeTargets) {
        String key = call + "/" + method.getName();
        if (StringUtils.isNotEmpty(path)) {
            key = path;
        }
        InvokeTarget invokeTarget = new InvokeTarget(class1, method, targetPackageName, classSuffix);
        if (invokeTargets.containsKey(key)) {
            // 既に指定のパスが使われている
            log.error("Target duplicated. [" + key + "]");
            throw new SystemException("Target duplicated. [" + key + "]");
        }

        invokeTargets.put(key, invokeTarget);
        // 小文字のみでもアクセス可能にする
        invokeTargets.put(key.toLowerCase(), invokeTarget);
        if (log.isDebugEnabled()) {
            log.debug("Add targget. [" + key + "]");
        }
    }

    /**
     * パス文字列から、対応するコントローラーのインスタンスと、 実行するメソッドを取得する
     * 
     * @param method HttpMethod
     * @param path パス文字列
     * @return 実行するターゲット
     */
    public InvokeTarget getController(HttpMethod method, String path) {
        Map<String, InvokeTarget> invokeTargets = invokeDeleteTargets;
        if (method == HttpMethod.get) {
            invokeTargets = invokeGetTargets;
        } else if (method == HttpMethod.post) {
            invokeTargets = invokePostTargets;
        } else if (method == HttpMethod.put) {
            invokeTargets = invokePutTargets;
        }
        InvokeTarget target = invokeTargets.get(path);
        if (target != null) {
            InvokeTarget copy = target.copy();
            return copy;
        }
        return null;
    }

}
