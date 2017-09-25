package org.support.project.web.logic;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.support.project.common.classanalysis.ClassAnalysis;
import org.support.project.common.classanalysis.ClassAnalysisFactory;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.PropertyUtil;
import org.support.project.common.util.StringUtils;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.annotation.Auth;
import org.support.project.web.bean.LoginedUser;
import org.support.project.web.common.HttpStatus;
import org.support.project.web.common.HttpUtil;
import org.support.project.web.common.InvokeSearch;
import org.support.project.web.common.InvokeTarget;
import org.support.project.web.config.HttpMethod;
import org.support.project.web.control.Control;
import org.support.project.web.exception.CallControlException;
import org.support.project.web.exception.InvalidParamException;

import net.arnx.jsonic.JSONException;


@DI(instance = Instance.Singleton)
public class CallControlLogic {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(CallControlLogic.class);
    public static CallControlLogic get() {
        return Container.getComp(CallControlLogic.class);
    }
    /** 対象外のパスの正規表現のデフォルト */
    private static final String IGNORE_REGULAR_EXPRESSION = "^open|css$|js$|jpg$|jpeg$|gif$|png$|init$";
    /** 対象外のパスの正規表現のルール */
    private Pattern ignoreRegularExpressionPattern = null;
    /** クラス検索 */
    private InvokeSearch invokeSearch;
    /**
     * 初期化
     * @param controlPackage コントローラーのパッケージ名称（カンマ区切り）
     * @param classSuffix クラスのサフィックス(デフォルト「Control」)
     * @param searchSubpackages コントローラーの検索をサブパッケージにも適用するか
     * @param ignoreRegularExpression このフィルタで処理しないものの正規表現
     */
    public void init(String controlPackage, String classSuffix, boolean searchSubpackages, String ignoreRegularExpression) {
        String[] controlPackages; // 
        if (controlPackage.indexOf(",") != -1) {
            controlPackages = controlPackage.split(",");
        } else {
            controlPackages = new String[1];
            controlPackages[0] = controlPackage;
        }
        if (StringUtils.isNotEmpty(ignoreRegularExpression)) {
            this.ignoreRegularExpressionPattern = Pattern.compile(ignoreRegularExpression);
        } else {
            this.ignoreRegularExpressionPattern = Pattern.compile(IGNORE_REGULAR_EXPRESSION);
        }
        // 対象のクラスを登録
        this.invokeSearch = Container.getComp(InvokeSearch.class);
        for (String target : controlPackages) {
            invokeSearch.addTarget(target, classSuffix, searchSubpackages);
        }
    }
    /**
     * パスで取得されるControlクラスを呼び出す
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws CallControlException CallControlException
     * @throws InvalidParamException 
     * @throws IOException 
     * @throws JSONException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchAlgorithmException 
     */
    public InvokeTarget searchInvokeTarget(HttpServletRequest request, HttpServletResponse response)
            throws CallControlException, InstantiationException, IllegalAccessException, JSONException,
            IOException, InvalidParamException, NoSuchAlgorithmException {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(request.getServletPath());
        if (request.getPathInfo() != null && request.getPathInfo().length() > 0) {
            pathBuilder.append(request.getPathInfo());
        }
        if (ignoreRegularExpressionPattern != null) {
            Matcher matcher = ignoreRegularExpressionPattern.matcher(pathBuilder.toString());
            if (matcher.find()) {
                return null;
            }
        }
        String path = request.getServletPath();
        LOG.trace("real path : " + path);
        String pathInfo = null;
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        if (StringUtils.countOccurrencesOf(path, "/") > 1) {
            pathInfo = path.substring(path.indexOf("/", path.indexOf("/") + 1));
            path = path.substring(0, path.indexOf("/", path.indexOf("/") + 1));
        }
        if (path.length() == 0) {
            path = "index";
        }
        if (path.indexOf("/") == -1) {
            // メソッド指定無し
            path = path + "/index";
        }
        if (path.endsWith("/")) {
            if (path.indexOf("/") != path.lastIndexOf("/")) {
                // "/"が複数あり、最後が"/"になっている
                path = path.substring(0, path.length() - 1);
            } else {
                // メソッド指定無し
                path = path + "index";
            }
        }
        if (LOG.isTraceEnabled()) {
            LOG.trace("path : " + path);
            LOG.trace("pathinfo : " + pathInfo);
        }

        String method = request.getMethod().toLowerCase();
        HttpMethod m = HttpMethod.get;
        if (method.equals("post")) {
            m = HttpMethod.post;
        } else if (method.equalsIgnoreCase("put")) {
            m = HttpMethod.put;
        } else if (method.equalsIgnoreCase("delete")) {
            m = HttpMethod.delete;
        }
        
        InvokeTarget invokeTarget = invokeSearch.getController(m, path, pathInfo);
        if (invokeTarget != null) {
            HttpRequestCheckLogic check = HttpRequestCheckLogic.get();
            if (!check.checkCSRF(invokeTarget, request)) {
                // CSRFチェック対象であればチェック実施
                throw new CallControlException(HttpStatus.SC_403_FORBIDDEN);
            }
            // CSRF用のリクエストキーなど発行
            check.setCSRFTocken(invokeTarget, request, response);
            
            // コントローラーで処理を呼び出す場合、パラメータは全てリクエストのアトリビュートにコピーする
            this.copyAttribute(request);
            // パスで取得できる値があればセット
            for (Entry<String, String> entry : invokeTarget.getPathValue().entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }

            if (auth(invokeTarget, request, response, path, pathInfo)) {
                return this.setInvokeParams(invokeTarget, request, response, path, pathInfo);
            } else {
                // 認可エラー
                throw new CallControlException(HttpStatus.SC_403_FORBIDDEN);
            }
        }
        return null;
    }
    
    /**
     * リクエストのパラメータを、全て、アトリビュートでもアクセス可能にする為、コピーする
     * 
     * @param request request
     */
    private void copyAttribute(HttpServletRequest request) {
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            if (request.getParameterValues(name) != null) {
                if (request.getParameterValues(name).length > 1) {
                    request.setAttribute(name, request.getParameterValues(name));
                } else {
                    request.setAttribute(name, request.getParameter(name));
                }
            } else {
                request.setAttribute(name, request.getParameter(name));
            }
        }
    }
    
    /**
     * 指定の機能(メソッド)にアクセス可能かチェックする
     * 
     * @param invokeTarget invokeTarget
     * @param request request
     * @param response response
     * @param pathInfo pathInfo
     * @param path path
     * @return result
     */
    protected boolean auth(InvokeTarget invokeTarget, HttpServletRequest request, HttpServletResponse response, String path, String pathInfo) {
        Auth auth = invokeTarget.getTargetMethod().getAnnotation(Auth.class);
        if (auth != null) {
            String[] roles = auth.roles();
            LoginedUser loginedUser = HttpUtil.getLoginedUser(request);
            if (loginedUser == null) {
                return false;
            }
            for (String role : roles) {
                if (request.isUserInRole(role)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    /**
     * コントローラの処理を呼び出し
     * 
     * @param invokeTarget invokeTarget
     * @param request request
     * @param response response
     * @param pathInfo pathInfo
     * @param path path
     * @return result
     * @throws InvalidParamException 
     * @throws IOException 
     * @throws JSONException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    protected InvokeTarget setInvokeParams(InvokeTarget invokeTarget, HttpServletRequest request, HttpServletResponse response,
            String path, String pathInfo) throws InstantiationException, IllegalAccessException, JSONException, IOException, InvalidParamException {
        // サービスクラス内に、HttpServletRequest HttpServletResponseのフィールドが存在すればセットする
        ClassAnalysis classAnalysis = ClassAnalysisFactory.getClassAnalysis(invokeTarget.getTargetClass());
        Object invoke = invokeTarget.getTarget();

        List<String> props = classAnalysis.getPropertyNames();
        for (String prop : props) {
            if (HttpServletRequest.class.isAssignableFrom(classAnalysis.getPropertyType(prop))) {
                PropertyUtil.setPropertyValue(invoke, prop, request);
            } else if (HttpServletResponse.class.isAssignableFrom(classAnalysis.getPropertyType(prop))) {
                PropertyUtil.setPropertyValue(invoke, prop, response);
            } else if (InvokeTarget.class.isAssignableFrom(classAnalysis.getPropertyType(prop))) {
                PropertyUtil.setPropertyValue(invoke, prop, invokeTarget);
            }
        }
        
        // 実行のパラメータを準備
        Class<?>[] parameterClass = invokeTarget.getTargetMethod().getParameterTypes();
        Object[] params = null;
        if (parameterClass == null || parameterClass.length == 0) {
            // invokeTarget.invoke(null);
            params = null;
        } else {
            params = new Object[parameterClass.length];
            int cnt = 0;
            for (Class<?> class1 : parameterClass) {
                if (HttpServletRequest.class.isAssignableFrom(class1)) {
                    params[cnt] = request;
                } else if (HttpServletResponse.class.isAssignableFrom(class1)) {
                    params[cnt] = response;
                } else {
                    Object param = HttpUtil.parseRequest(request, class1);
                    params[cnt] = param;
                }
                cnt++;
            }
        }

        if (Control.class.isAssignableFrom(invokeTarget.getTargetClass())) {
            Control control = (Control) invoke;
            control.setPath(path);
            control.setPathInfo(pathInfo);
        }
        invokeTarget.setParams(params);
        return invokeTarget;
    }
    
    
}
