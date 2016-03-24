package org.support.project.web.logic;

import java.io.File;

import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.web.config.AppConfig;

public class ScheduledBatchLogicCall {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(ScheduledBatchLogicCall.class);

    public static void main(String[] args) throws InterruptedException {
        AppConfig appConfig = AppConfig.get();

        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File classDir = new File(classpath);
        File base = classDir.getParentFile();
        LOG.info("base : " + base.getAbsolutePath());
        appConfig.setWebRealPath(base.getAbsolutePath());
        
        ScheduledBatchLogic logic = ScheduledBatchLogic.get();
        logic.setAddTestClassDir(true);
        logic.scheduleInitialize();
        
        int count = 0;
        while (count < 10) {
            LOG.info("バッチが起動されるのを待ってます");
            Thread.sleep(1000 * 60);
        }
        
        logic.scheduleDestroy();
    }

}
