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
import org.support.project.web.bean.MessageResult;
import org.support.project.web.config.AppConfig;


public abstract class CallBatchEndpoint extends AbstractEndpoint {
	/** ログ */
	private static final Log LOG = LogFactory.getLog(CallBatchEndpoint.class);

	private Thread thread;
	
	protected void call(Session session, Class<?> batch) {
		// バッチプログラム実行
		AppConfig appConfig = AppConfig.get();
		
		LOG.info(appConfig.getWebRealPath());
		
		AsyncJavaJob job = new AsyncJavaJob();
		job.addjarDir(new File(appConfig.getWebRealPath().concat("/WEB-INF/lib/")));
		job.addClassPathDir(new File(appConfig.getWebRealPath().concat("/WEB-INF/classes/")));
		job.setMainClass(batch.getName());
		job.setConsoleListener(new ConsoleListener() {
			@Override
			public void write(String message) {
				LOG.info(message);
				try {
					if (message.startsWith("[SEND]")) {
						MessageResult result = new MessageResult();
						result.setMessage(message.substring("[SEND]".length()));
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
					session.close();
				} catch (JSONException | IOException e) {
					LOG.warn("websocket message send error", e);
				}
			}
		});
		
		thread = new Thread(job);
		thread.start();
	}

	
}
