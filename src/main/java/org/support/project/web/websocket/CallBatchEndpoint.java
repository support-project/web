package org.support.project.web.websocket;

import java.io.File;
import java.io.IOException;

import javax.websocket.Session;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

import org.support.project.common.bat.AsyncJavaJob;
import org.support.project.common.bat.BatListener;
import org.support.project.common.bat.ConsoleListener;
import org.support.project.common.bat.JobResult;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.StringUtils;
import org.support.project.web.bean.MessageResult;
import org.support.project.web.config.AppConfig;


public abstract class CallBatchEndpoint extends AbstractEndpoint {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(CallBatchEndpoint.class);

    private Thread thread;
    
    protected abstract void finishJob(JobResult result, Session session);
    
    private String sendPlefix = "[SEND]";
    
    protected void call(Session session, Class<?> batch) {
        // バッチプログラム実行
        AppConfig appConfig = AppConfig.get();
        
        LOG.info(appConfig.getWebRealPath());
        
        String envValue = System.getenv(AppConfig.getEnvKey());
        
        AsyncJavaJob job = new AsyncJavaJob();
        job.addjarDir(new File(appConfig.getWebRealPath().concat("/WEB-INF/lib/")));
        job.addClassPathDir(new File(appConfig.getWebRealPath().concat("/WEB-INF/classes/")));
        job.setMainClass(batch.getName());
        if (StringUtils.isNotEmpty(envValue)) {
            job.addEnvironment(AppConfig.getEnvKey(), envValue);
        }
        job.setXmx(256);
        job.setConsoleListener(new ConsoleListener() {
            @Override
            public void write(String message) {
                LOG.info(message);
                try {
                    if (StringUtils.isNotEmpty(sendPlefix)) {
                        if (message.startsWith(sendPlefix)) {
                            MessageResult result = new MessageResult();
                            result.setMessage(message.substring(sendPlefix.length()));
                            session.getBasicRemote().sendText(JSON.encode(result));
                        }
                    } else {
                        MessageResult result = new MessageResult();
                        result.setMessage(message);
                        session.getBasicRemote().sendText(JSON.encode(result));
                    }
                } catch (JSONException | IOException e) {
                    LOG.warn("websocket message send error", e);
                }
            }
        });
        
        job.addListener(new BatListener() {
            @Override
            public void finish(JobResult result) {
                MessageResult message = new MessageResult();
                message.setMessage("Processing has been completed. [status]" + result.getResultCode());
                try {
                    session.getBasicRemote().sendText(JSON.encode(message));
                    //session.close();
                    finishJob(result, session);
                } catch (JSONException | IOException e) {
                    LOG.warn("websocket message send error", e);
                }
            }
        });
        
        thread = new Thread(job);
        thread.start();
    }



    /**
     * @return the sendPlefix
     */
    public String getSendPlefix() {
        return sendPlefix;
    }



    /**
     * @param sendPlefix the sendPlefix to set
     */
    public void setSendPlefix(String sendPlefix) {
        this.sendPlefix = sendPlefix;
    }
    
}
