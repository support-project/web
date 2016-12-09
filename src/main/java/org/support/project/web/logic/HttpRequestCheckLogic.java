package org.support.project.web.logic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.serialize.SerializeUtils;
import org.support.project.common.util.StringUtils;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.bean.CSRFTokens;
import org.support.project.web.common.HttpUtil;
import org.support.project.web.common.InvokeTarget;
import org.support.project.web.config.AppConfig;
import org.support.project.web.config.WebConfig;
import org.support.project.web.control.service.Delete;
import org.support.project.web.control.service.Get;
import org.support.project.web.control.service.Post;
import org.support.project.web.control.service.Put;
import org.support.project.web.dao.SystemConfigsDao;
import org.support.project.web.entity.SystemConfigsEntity;

import net.arnx.jsonic.JSON;

@DI(instance = Instance.Singleton)
public class HttpRequestCheckLogic {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(HttpRequestCheckLogic.class);
    /** セッション／Cookieに格納するキー */
    private static final String CSRF_TOKENS = "CSRFTokens";
    
    /**
     * Get instance
     * @return instance
     */
    public static HttpRequestCheckLogic get() {
        return Container.getComp(HttpRequestCheckLogic.class);
    }
    
    /**
     * CSRFの簡易対策で、Referrerをチェックする
     * @param request
     * @return
     */
    public boolean checkReferrer(HttpServletRequest request) {
        SystemConfigsDao dao = SystemConfigsDao.get();
        SystemConfigsEntity config = dao.selectOnKey(WebConfig.KEY_SYSTEM_URL, AppConfig.get().getSystemName());
        if (config == null) {
            // システムのURLがわからないので、チェックは成功とする
            return true;
        }
        String url = config.getConfigValue();
        String referrer = request.getHeader("REFERER");
        if (referrer.startsWith(url)) {
            return true;
        }
        LOG.warn("It is a request from outside the system.");
        LOG.warn("Request: " + HttpUtil.getRequestInfo(request));
        LOG.warn("Referer: " + referrer);
        return false;
    }

    private String getSubscribeToken(InvokeTarget invokeTarget) {
        Method method = invokeTarget.getTargetMethod();
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Get) {
                Get config = (Get) annotation;
                return config.subscribeToken();
            } else if (annotation instanceof Put) {
                Put config = (Put) annotation;
                return config.subscribeToken();
            } else if (annotation instanceof Post) {
                Post config = (Post) annotation;
                return config.subscribeToken();
            } else if (annotation instanceof Delete) {
                Delete config = (Delete) annotation;
                return config.subscribeToken();
            }
        }
        return "";
    }
    
    private String getPublishToken(InvokeTarget invokeTarget) {
        Method method = invokeTarget.getTargetMethod();
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Get) {
                Get config = (Get) annotation;
                return config.publishToken();
            } else if (annotation instanceof Put) {
                Put config = (Put) annotation;
                return config.publishToken();
            } else if (annotation instanceof Post) {
                Post config = (Post) annotation;
                return config.publishToken();
            } else if (annotation instanceof Delete) {
                Delete config = (Delete) annotation;
                return config.publishToken();
            }
        }
        return "";
    }
    
    public void setCSRFTocken(InvokeTarget invokeTarget, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
        String tokenkey = getPublishToken(invokeTarget);
        if (!StringUtils.isEmpty(tokenkey)) {
            HttpSession session = request.getSession();
            CSRFTokens tokens = (CSRFTokens) session.getAttribute(CSRF_TOKENS);
            if (tokens == null) {
                tokens = new CSRFTokens();
                session.setAttribute(CSRF_TOKENS, tokens);
            }
            tokens.addToken(tokenkey);
            HttpUtil.setCookie(request, response, CSRF_TOKENS, SerializeUtils.objectToBase64(tokens));
        }
    }

    public boolean checkCSRFTocken(InvokeTarget invokeTarget, HttpServletRequest request) {
        String tokenkey = getSubscribeToken(invokeTarget);
        if (StringUtils.isEmpty(tokenkey)) {
            // token チェックの対象になっていない
            return true;
        }
        
        HttpSession session = request.getSession();
        CSRFTokens tokens = (CSRFTokens) session.getAttribute(CSRF_TOKENS);
        if (tokens == null) {
            return false;
        }
        String base64 = HttpUtil.getCookie(request, CSRF_TOKENS);
        CSRFTokens reqTokens = SerializeUtils.Base64ToObject(base64, CSRFTokens.class);
        if (tokens.checkToken(tokenkey, reqTokens)) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("Token OK : " + tokenkey);
            }
            return true;
        }
        // Tokenを持たずに、処理を実行しようとした（本来通るべき画面をとおっていない？）
        LOG.warn("Token NG : " + tokenkey);
        return false;
    }

}
