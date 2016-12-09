package org.support.project.web.logic;

import javax.servlet.http.HttpServletRequest;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.common.HttpUtil;
import org.support.project.web.config.AppConfig;
import org.support.project.web.config.WebConfig;
import org.support.project.web.dao.SystemConfigsDao;
import org.support.project.web.entity.SystemConfigsEntity;

@DI(instance = Instance.Singleton)
public class HttpRequestCheckLogic {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(HttpRequestCheckLogic.class);

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

}
