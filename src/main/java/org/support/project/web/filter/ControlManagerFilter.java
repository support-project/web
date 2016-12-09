package org.support.project.web.filter;

import java.io.IOException;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.support.project.common.classanalysis.ClassAnalysis;
import org.support.project.common.classanalysis.ClassAnalysisFactory;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.PropertyUtil;
import org.support.project.common.util.StringUtils;
import org.support.project.di.Container;
import org.support.project.web.annotation.Auth;
import org.support.project.web.bean.LoginedUser;
import org.support.project.web.boundary.Boundary;
import org.support.project.web.common.HttpStatus;
import org.support.project.web.common.HttpUtil;
import org.support.project.web.common.InvokeSearch;
import org.support.project.web.common.InvokeTarget;
import org.support.project.web.config.HttpMethod;
import org.support.project.web.control.Control;
import org.support.project.web.logic.HttpRequestCheckLogic;

/**
 * リクエストのパス
 * 
 * @author Koda
 *
 */
public class ControlManagerFilter implements Filter {
    /** ログ */
    private static Log log = LogFactory.getLog(ControlManagerFilter.class);

    /** コントローラーのパッケージ名称 */
    private String[] controlPackages;
    /** クラスのサフィックス(デフォルト「Control」) */
    private String classSuffix;
    /** コントローラーの検索をサブパッケージにも適用するか(デフォルト「true」) */
    private boolean subpackages;

    /** このフィルタで処理しないもの */
    private String ignoreRegularExpression = "^open|css$|js$|jpg$|jpeg$|gif$|png$|init$";
    private Pattern pattern = null;

    /** クラス検索 */
    private InvokeSearch invokeSearch;

    @Override
    public void destroy() {
        this.controlPackages = null;
        this.classSuffix = null;
        this.subpackages = false;
        this.invokeSearch = null;
    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
        String controlPackage = filterconfig.getInitParameter("controlPackage");
        if (controlPackage == null) {
            throw new ServletException("control package name is required.");
        }

        if (controlPackage.indexOf(",") != -1) {
            this.controlPackages = controlPackage.split(",");
        } else {
            this.controlPackages = new String[1];
            this.controlPackages[0] = controlPackage;
        }
        this.classSuffix = filterconfig.getInitParameter("classSuffix");
        String sub = filterconfig.getInitParameter("subpackages");

        if (classSuffix == null) {
            classSuffix = "Control";
        }
        subpackages = true;
        if (sub != null && sub.toLowerCase().equals("false")) {
            subpackages = false;
        }

        String ignoreRegularExpression = filterconfig.getInitParameter("ignore-regular-expression");
        if (StringUtils.isNotEmpty(ignoreRegularExpression)) {
            this.ignoreRegularExpression = ignoreRegularExpression;
        }
        if (StringUtils.isNotEmpty(this.ignoreRegularExpression)) {
            this.pattern = Pattern.compile(this.ignoreRegularExpression);
        }

        // 対象のクラスを登録
        invokeSearch = Container.getComp(InvokeSearch.class);
        for (String target : controlPackages) {
            invokeSearch.addTarget(target, classSuffix, subpackages);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {

            StringBuilder pathBuilder = new StringBuilder();
            pathBuilder.append(request.getServletPath());
            if (request.getPathInfo() != null && request.getPathInfo().length() > 0) {
                pathBuilder.append(request.getPathInfo());
            }
            if (pattern != null) {
                Matcher matcher = pattern.matcher(pathBuilder.toString());
                if (matcher.find()) {
                    // 対象外なのでスルー
                    filterChain.doFilter(request, response);
                    return;
                }
            }
            String path = request.getServletPath();
            log.trace("real path : " + path);
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
            if (log.isTraceEnabled()) {
                log.trace("path : " + path);
                log.trace("pathinfo : " + pathInfo);
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
            
            if (m != HttpMethod.get) {
                // CSRFの簡易対策で、Referrerをチェックする
                HttpRequestCheckLogic check = HttpRequestCheckLogic.get();
                if (!check.checkReferrer(request)) {
                    response.sendError(HttpStatus.SC_403_FORBIDDEN);
                    return;
                }
            }
            
            InvokeTarget invokeTarget = invokeSearch.getController(m, path);
            if (invokeTarget != null) {
                HttpRequestCheckLogic check = HttpRequestCheckLogic.get();
                if (!check.checkCSRFTocken(invokeTarget, request)) {
                    response.sendError(HttpStatus.SC_403_FORBIDDEN);
                    return;
                }
                check.setCSRFTocken(invokeTarget, request, response);
                
                // コントローラーで処理を呼び出す場合、パラメータは全てリクエストのアトリビュートにコピーする
                this.copyAttribute(request);

                if (auth(invokeTarget, request, response, path, pathInfo)) {
                    this.invoke(invokeTarget, request, response, path, pathInfo);
                } else {
                    // 認可エラー
                    response.sendError(HttpStatus.SC_403_FORBIDDEN);
                    return;
                }
            } else {
                filterChain.doFilter(request, response);
                return;
            }
        } catch (Exception e) {
            log.trace("any exception is thrown. [" + e.getClass().getName() + "]", e);
            if (e.getCause() != null) {
                log.trace("[Cause]" + e.getCause().getMessage(), e.getCause());
            }

            if (e instanceof SocketException) {
                log.debug("SocketException. " + e.getMessage());
                // ソケットがおかしくなっているので何も出来ない
            } else {
                // HttpUtil.forward(response, request, "/open/errors/error.jsp");
                if (!response.isCommitted()) {
                    log.error("ERROR SEND");
                    response.sendError(HttpStatus.SC_500_INTERNAL_SERVER_ERROR);
                }
            }
            // LoggingFilterへ
            if (e instanceof ServletException) {
                throw (ServletException) e;
            } else if (e instanceof IOException) {
                throw (IOException) e;
            } else {
                throw new ServletException(e);
            }
        }
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
     * @throws Exception Exception
     */
    protected void invoke(InvokeTarget invokeTarget, HttpServletRequest request, HttpServletResponse response, String path, String pathInfo)
            throws Exception {
        Object result = doInvoke(invokeTarget, request, response, path, pathInfo);
        if (result instanceof Boundary) {
            Boundary boundary = (Boundary) result;
            boundary.navigate();
        }
    }

    /**
     * コントローラの処理を呼び出し
     * 
     * @param invokeTarget invokeTarget
     * @param request request
     * @param response response
     * @param pathInfo pathInfo
     * @param path path
     * @throws Exception Exception
     * @return result
     */
    protected Object doInvoke(InvokeTarget invokeTarget, HttpServletRequest request, HttpServletResponse response, String path, String pathInfo)
            throws Exception {
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
        return invokeTarget.invoke(params);
    }
}
