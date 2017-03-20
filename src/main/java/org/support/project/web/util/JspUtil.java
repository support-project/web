package org.support.project.web.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.support.project.common.config.AppConfig;
import org.support.project.common.config.ConfigLoader;
import org.support.project.common.config.Resources;
import org.support.project.common.exception.ParseException;
import org.support.project.common.exception.SystemException;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.HtmlUtils;
import org.support.project.common.util.PropertyUtil;
import org.support.project.common.util.StringUtils;
import org.support.project.web.bean.LoginedUser;
import org.support.project.web.common.HttpUtil;
import org.support.project.web.config.CommonWebParameter;
import org.support.project.web.logic.SanitizingLogic;

/**
 * Utility for jsp
 * 
 * @author Koda
 */
public class JspUtil {
    // public static final String PATH_ANTISAMY_POLICY = "/antisamy-policy.xml";
    public static final String TIME_ZONE_OFFSET = "TIME_ZONE_OFFSET";
    /** Escape flag: none */
    public static final int ESCAPE_NONE = -1;
    /** Escape flag: html tag escape */
    public static final int ESCAPE_HTML = 0;
    /** Escape flag: clear(danger tag is only clean) */
    public static final int ESCAPE_CLEAR = 1;

    /** ログ */
    private static final Log LOG = LogFactory.getLog(JspUtil.class);

    private HttpServletRequest request;
    private PageContext pageContext;

    /**
     * Constractor
     * 
     * @param request request
     * @param pageContext pageContext
     */
    public JspUtil(HttpServletRequest request, PageContext pageContext) {
        super();
        this.request = request;
        this.pageContext = pageContext;
    }

    /**
     * Jspの状態がわからないので、デバッグ出力
     */
    public void debug() {
        if (LOG.isDebugEnabled()) {
            StringBuilder path = new StringBuilder();

            path.append(request.getMethod());
            path.append("\t");

            path.append(request.getScheme());
            path.append("://");
            path.append(request.getServerName());
            if (request.getServerPort() != 80 && request.getServerPort() != 443) {
                path.append(":");
                path.append(request.getServerPort());
            }
            if (StringUtils.isNotEmpty(request.getContextPath())) {
                path.append(request.getContextPath());
            }
            if (StringUtils.isNotEmpty(request.getServletPath())) {
                path.append(request.getServletPath());
            }
            if (StringUtils.isNotEmpty(request.getPathInfo())) {
                path.append(request.getPathInfo());
            }
            if (StringUtils.isNotEmpty(request.getQueryString())) {
                path.append("?");
                path.append(request.getQueryString());
            }
            LOG.debug(path.toString());

            StringBuilder builder = new StringBuilder();
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String string = (String) params.nextElement();
                builder.append("[param]").append(string).append(":");
                // String[] values = request.getParameterValues(string);
                // if (values == null) {
                // builder.append("");
                // } else {
                // int count = 0;
                // for (String val : values) {
                // if (count > 0) {
                // builder.append(",");
                // }
                // builder.append(val);
                // count++;
                // }
                // }
                builder.append("\n");
            }
            LOG.debug("---- request parameter ----\n" + builder.toString());
            LOG.debug("---- ----------------- ----");

            builder = new StringBuilder();
            params = request.getAttributeNames();
            while (params.hasMoreElements()) {
                String string = (String) params.nextElement();
                builder.append("[param]").append(string).append(":");
                // Object values = request.getAttribute(string);
                // builder.append(PropertyUtil.reflectionToString(values));
                builder.append("\n");
            }
            LOG.debug("---- request attribute ----\n" + builder.toString());
            LOG.debug("---- ----------------- ----");

            builder = new StringBuilder();
            params = pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE);
            while (params.hasMoreElements()) {
                String string = (String) params.nextElement();
                builder.append("[param]").append(string).append(":");
                // Object values = pageContext.getAttribute(string);
                // builder.append(PropertyUtil.reflectionToString(values));
                builder.append("\n");
            }
            LOG.debug("---- pageContext attribute ----\n" + builder.toString());
            LOG.debug("---- ----------------- ----");
        }
    }

    /**
     * LoginedUserの情報取得（ログインしていないとNull）
     * 
     * @return LoginedUser
     */
    public LoginedUser user() {
        HttpSession session = request.getSession();
        LoginedUser loginedUser = (LoginedUser) session.getAttribute(CommonWebParameter.LOGIN_USER_INFO_SESSION_KEY);
        return loginedUser;
    }

    /**
     * get login user name
     * 
     * @return user name
     */
    public String name() {
        LoginedUser loginedUser = user();
        if (loginedUser != null) {
            return HtmlUtils.escapeHTML(loginedUser.getLoginUser().getUserName());
        }
        return "";
    }

    /**
     * get login user id
     * 
     * @return user id
     */
    public String id() {
        LoginedUser loginedUser = user();
        if (loginedUser != null) {
            return String.valueOf(loginedUser.getUserId());
        }
        return "";
    }

    /**
     * check of user id logined.
     * 
     * @return result
     */
    public boolean logined() {
        return StringUtils.isNotEmpty(id());
    }

    /**
     * check of login user is admin.
     * 
     * @return result
     */
    public boolean isAdmin() {
        LoginedUser loginedUser = user();
        if (loginedUser != null) {
            return loginedUser.isAdmin();
        }
        return false;
    }

    /**
     * check of login user have role.
     * 
     * @param roles roles
     * @return result
     */
    public boolean haveRole(String... roles) {
        LoginedUser loginedUser = user();
        if (loginedUser != null) {
            return loginedUser.haveRole(roles);
        }
        return false;
    }

    /**
     * 指定の値を取得
     * 
     * @param param parameter name
     * @param clazz type
     * @param <T> type
     * @return value
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public <T> T getValue(final String param, Class<? extends T> clazz) throws InstantiationException, IllegalAccessException {
        return getValue(param, clazz, null);
    }

    /**
     * 指定の値を取得
     * 
     * @param param parameter name
     * @param clazz type
     * @param defaultValue default value
     * @param <T> type
     * @return value
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public <T> T getValue(final String param, Class<? extends T> clazz, Object defaultValue) throws InstantiationException, IllegalAccessException {
        Object obj = null;
        String propertyName = null;
        String paramName = param;

        // if (LOG.isDebugEnabled()) {
        // LOG.debug("***** get value debug start");
        // LOG.debug("[request attribute]");
        // Enumeration<String> emEnumeration = request.getAttributeNames();
        // while (emEnumeration.hasMoreElements()) {
        // String param = (String) emEnumeration.nextElement();
        // LOG.debug(param);
        // if (request.getAttribute(param) != null) {
        // LOG.debug(request.getAttribute(param).getClass().getName());
        // } else {
        // LOG.debug("null");
        // }
        // }
        // LOG.debug("***** get value debug end");
        // }

        if (paramName.indexOf(".") != -1) {
            String[] params = paramName.split("\\.");
            paramName = params[0];
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < params.length; i++) {
                if (i > 1) {
                    builder.append(".");
                }
                builder.append(params[i]);
            }
            propertyName = builder.toString();
        }
        obj = pageContext.findAttribute(paramName);
        if (request.getAttribute(paramName) != null) {
            obj = request.getAttribute(paramName);
        }
        if (StringUtils.isEmpty(obj) && request.getParameter(paramName) != null) {
            obj = request.getParameter(paramName);
        }
        if (StringUtils.isEmpty(obj)) {
            HttpSession session = request.getSession();
            if (session.getAttribute(paramName) != null) {
                if (session.getAttribute(paramName) != null) {
                    obj = session.getAttribute(paramName);
                }
            }
        }

        if (defaultValue == null) {
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterTypes().length == 0) {
                    defaultValue = clazz.newInstance();
                    break;
                }
            }
        }

        if (obj == null) {
            return (T) defaultValue;
        }
        if (StringUtils.isNotEmpty(propertyName)) {
            if (propertyName.indexOf("()") != -1) {
                // メソッド直接指定
                String methodName = propertyName.substring(0, propertyName.indexOf("()"));
                try {
                    Method method = obj.getClass().getMethod(methodName, null);
                    obj = method.invoke(obj, null);
                } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
                    obj = "";
                }
            } else {
                if (PropertyUtil.getPropertyNames(obj.getClass()).contains(propertyName)) {
                    obj = PropertyUtil.getPropertyValue(obj, propertyName);
                } else {
                    obj = "";
                }
            }
        }
        if (obj == null) {
            return (T) defaultValue;
        }
        if (!clazz.isAssignableFrom(obj.getClass())) {
            LOG.debug(param + " is not " + clazz.getName() + " : " + obj.getClass().getName());
            return null;
        }

        return (T) obj;
    }

    /**
     * 値を出力
     * 
     * @param paramName parameter name
     * @return string
     * @throws ParseException ParseException
     */
    public String out(String paramName) throws ParseException {
        return out(paramName, ESCAPE_HTML);
    }

    /**
     * 値を出力
     * 
     * @param paramName parameter name
     * @param escape escape
     * @return string
     * @throws ParseException ParseException
     */
    public String out(String paramName, int escape) throws ParseException {
        return out(paramName, escape, -1);
    }

    /**
     * 値を出力
     * 
     * @param paramName parameter name
     * @param escape escape
     * @param length max length
     * @return string
     * @throws ParseException ParseException
     */
    public String out(String paramName, int escape, int length) throws ParseException {
        try {
            Object str = getValue(paramName, Object.class, "");
            if (str == null) {
                return "";
            } else if (str != null && str instanceof String) {
                if (escape == ESCAPE_CLEAR) {
                    str = SanitizingLogic.get().sanitize((String) str);
                } else if (escape == ESCAPE_HTML) {
                    str = HtmlUtils.escapeHTML((String) str);
                }
            }
            if (length > 0) {
                String s = str.toString();
                if (escape == ESCAPE_CLEAR) {
                    if (s.length() > 4) {
                        // タグの途中で省略すると表示が崩れるので、タグは文字数のカウントに入れないようにする
                        StringBuilder builder = new StringBuilder();
                        int count = 0;
                        boolean tagstart = false; // いったん一つの階層のタグのみ（タグのネストには対応しない）
                        boolean endtagstart = false;
                        for (int i = 0; i < s.length(); i++) {
                            String c = s.substring(i, i + 1);
                            if ("<".equals(c)) {
                                tagstart = true;
                            } else if (endtagstart && ">".equals(c)) {
                                tagstart = false;
                                endtagstart = false;
                            } else {
                                if (tagstart && "/".equals(c)) {
                                    endtagstart = true;
                                }
                            }
                            if (!tagstart) {
                                count++;
                            }
                            builder.append(c);
                            if (count + 3 >= length) {
                                break;
                            }
                        }
                        if (count + 3 >= length) {
                            builder.append("...");
                        }
                        return builder.toString();
                    }
                } else {
                    return StringUtils.abbreviate(s, length);
                }
            }
            return str.toString();
        } catch (Exception e) {
            LOG.error("ERROR [" + paramName + "]", e);
            throw new SystemException(e);
        }
    }

    /**
     * 日付の値を表示
     * 
     * @param paramName parameter name
     * @return string of date
     * @throws IllegalAccessException IllegalAccessException
     * @throws InstantiationException InstantiationException
     */
    public String date(String paramName) throws InstantiationException, IllegalAccessException {
        return date(paramName, true);
    }

    /**
     * 日付の値を表示
     * 
     * @param paramName parameter name
     * @param convGMTtoLocal 保存されている値はGMTなので、ブラウザのロケールで変換をかけるかどうか
     * @return string of date
     * @throws IllegalAccessException IllegalAccessException
     * @throws InstantiationException InstantiationException
     */
    public String date(String paramName, boolean convGMTtoLocal) throws InstantiationException, IllegalAccessException {
        Date v = getValue(paramName, Timestamp.class, null);
        if (v == null) {
            v = getValue(paramName, Date.class, null);
        }
        if (v == null) {
            return "";
        }
        // 元のオブジェクトは操作せず、コピーオブジェクトで表示
        Date val = new Date(v.getTime());

        // DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, request.getLocale());
        // DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT, request.getLocale());
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.SHORT, request.getLocale());
        StringBuilder builder = new StringBuilder();
        if (convGMTtoLocal) {
            // TimeZone zone = dateFormat.getTimeZone();
            TimeZone zone = null;
            // ブラウザからoffsetを取得して補正をかける(dateFormat.getTimeZone()を実行したら、GMTだった。。。）
            String offset = HttpUtil.getCookie(request, TIME_ZONE_OFFSET);
            if (StringUtils.isEmpty(offset)) {
                AppConfig appConfig = ConfigLoader.load(AppConfig.APP_CONFIG, AppConfig.class);
                zone = TimeZone.getTimeZone(appConfig.getTime_zone());
            } else {
                if (StringUtils.isInteger(offset)) {
                    int off = Integer.parseInt(offset);
                    off = off / 60;
                    // GMT+09:00 が日本
                    StringBuilder offsetBuilder = new StringBuilder();
                    offsetBuilder.append("GMT");
                    if (off <= 0) {
                        offsetBuilder.append("+0");
                        off = off * -1; // 正の数へ
                    } else {
                        offsetBuilder.append("-0");
                    }
                    offsetBuilder.append(off);
                    offsetBuilder.append(":00");
                    LOG.trace(offsetBuilder.toString());

                    zone = TimeZone.getTimeZone(offsetBuilder.toString());
                }
            }
            if (zone == null) {
                zone = dateFormat.getTimeZone();
            }
            if (LOG.isTraceEnabled()) {
                LOG.trace(zone.getDisplayName());
                LOG.trace(zone.getRawOffset());
                LOG.trace(zone);
            }

            // ZoneId zoneId = ZoneId.of(zone.getID());
            // ZonedDateTime ztime = ZonedDateTime.ofInstant(val.toInstant(), zoneId);
            // ztime.plusSeconds(zone.getRawOffset() / 1000);
            // Date date = Date.from(ztime.toInstant());

            val.setTime(val.getTime() + zone.getRawOffset());
            builder.append(dateFormat.format(val));
        } else {
            builder.append(dateFormat.format(val));
            // builder.append(" ");
            // builder.append(timeFormat.format(val));
        }

        return builder.toString();
    }

    /**
     * 指定した値が等しいかチェック
     * 
     * @param val value
     * @param paramName parameter name
     * @return result
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public boolean is(Object val, String paramName) throws InstantiationException, IllegalAccessException {
        Object check = getValue(paramName, Object.class, "");
        if (check == null) {
            if (val == null) {
                return true;
            } else {
                return false;
            }
        }
        if (val instanceof String) {
            return val.equals(check.toString());
        }
        // 画面から送られるリクエストは、すべて文字列型になるので、文字列にして比較
        return String.valueOf(val).equals(check.toString());
    }

    /**
     * 指定した値が等しい場合、labelを出力
     * 
     * @param val value
     * @param paramName parameter name
     * @param label label
     * @return label or not
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public String is(Object val, String paramName, String label) throws InstantiationException, IllegalAccessException {
        if (is(val, paramName)) {
            return label;
        }
        return "";
    }

    /**
     * 指定した値が等しくない場合、labelを出力
     * 
     * @param val value
     * @param paramName parameter name
     * @param label label
     * @return label or not
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public String isnot(Object val, String paramName, String label) throws InstantiationException, IllegalAccessException {
        if (!is(val, paramName)) {
            return label;
        }
        return "";
    }

    /**
     * CheckBoxやRadio用のcheckedを必要に応じて出力
     * 
     * @param val value
     * @param paramName param name
     * @return string
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public String checked(Object val, String paramName) throws InstantiationException, IllegalAccessException {
        return checked(val, paramName, false);
    }

    /**
     * CheckBoxやRadio用のcheckedを必要に応じて出力
     * 
     * @param val value
     * @param paramName param name
     * @param defaultCheck check as default
     * @return string
     * @throws InstantiationException InstantiationException
     * @throws IllegalAccessException IllegalAccessException
     */
    public String checked(Object val, String paramName, boolean defaultCheck) throws InstantiationException, IllegalAccessException {
        if (is(val, paramName)) {
            return "checked=\"checked\"";
        }
        Object check = getValue(paramName, Object.class, "");
        if (StringUtils.isEmpty(check) && defaultCheck) {
            return "checked=\"checked\"";
        }
        return "";
    }

    /**
     * メッセージバンドルから文字を取得
     * 
     * <pre>
     * &lt;fmt:bundle&gt;は、リクエストからLocalを判定しているが、ユーザが表示文字を切り替えた時などに対応できないので、
     * 自作したものを通しておく。（今のところ切り替えには対応していない） （切り替えた情報はセッションにいれておく）
     * </pre>
     * 
     * @param key key
     * @param params 置換用のパラメータ
     * @return label
     */
    public String label(String key, String... params) {
        Locale locale = HttpUtil.getLocale(request);
        return Resources.getInstance(locale).getResource(key, params);
    }

    /**
     * ロケールを取得
     * 
     * @return locale
     */
    public Locale locale() {
        return HttpUtil.getLocale(request);
    }

    /**
     * ロケールの国名を表示
     * 
     * @param localeKey localeKey
     * @return country name
     */
    public Locale locale(String localeKey) {
        String language = "";
        String country = "";
        String variant = "";

        if (localeKey.indexOf("_") == -1) {
            language = localeKey;
        } else {
            String[] params = localeKey.split("_");
            if (params.length > 0) {
                language = params[1];
            }
            if (params.length > 1) {
                country = params[2];
            }
            if (params.length > 2) {
                variant = params[3];
            }
        }
        return new Locale(language, country, variant);
    }

    /**
     * JSやCSSはモバイルブラウザがキャッシュする このため、更新してもキャッシュが使われてしまい動作できない事がある
     * 
     * そこで、JSやCSSのファイルのサフィックスにシステムバージョンを付与しておき、 バージョンアップした際に必ず更新されるようにする
     * 
     * @param filepath filepath
     * @return reload url
     */
    public String mustReloadFile(String filepath) {
        StringBuilder builder = new StringBuilder();
        builder.append(request.getContextPath());
        builder.append(filepath);
        builder.append("?ver=");
        Locale locale = HttpUtil.getLocale(request);
        builder.append(Resources.getInstance(locale).getResource("label.version"));
        return builder.toString();
    }

    /**
     * Cookieの値を取得
     * 
     * @param key key
     * @param defaultValue defaultValue
     * @return value
     */
    public String cookie(String key, String defaultValue) {
        return HttpUtil.getCookie(request, key, defaultValue);
    }
    
    /**
     * サニタイズした文字列を取得
     * @param obj
     * @return
     * @throws ParseException
     */
    public String sanitize(Object obj) throws ParseException {
        if (StringUtils.isEmpty(obj)) {
            return "";
        }
        return SanitizingLogic.get().sanitize(obj.toString());
    }
    
    
}
