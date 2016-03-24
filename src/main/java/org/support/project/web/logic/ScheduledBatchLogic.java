package org.support.project.web.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.support.project.common.bat.JavaJob;
import org.support.project.common.bat.JobResult;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.StringUtils;
import org.support.project.common.util.SystemUtils;
import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.bean.Batchinfo;
import org.support.project.web.config.AppConfig;

/**
 * 定期的にバッチ処理を実行するクラス
 * @author Koda
 */
@DI(instance = Instance.Singleton)
public class ScheduledBatchLogic {
    /** ログ */
    private static final Log LOG = LogFactory.getLog(ScheduledBatchLogic.class);
    /** インスタンス取得 */
    public static ScheduledBatchLogic get() {
        return Container.getComp(ScheduledBatchLogic.class);
    }
    
    /** スケジュールのプール */
    private ScheduledThreadPoolExecutor service;
    /** スケジュール化されたバッチ処理 */
    private List<ScheduledFuture<?>> futures = new ArrayList<>();
    
    /** Javaのバッチを呼び出す際に、テストクラスが格納されるディレクトリをクラスパスにセットするかどうか */
    private boolean addTestClassDir = false;
    
    /**
     * バッチをスケジュール登録
     * 
     * バッチはAppconfigに登録する
     */
    public void scheduleInitialize() {
        service = new ScheduledThreadPoolExecutor(1);
        List<Batchinfo> batchs = AppConfig.get().getBatchs();
        for (Batchinfo batchinfo : batchs) {
            if (batchinfo.getType() != null && batchinfo.getType().toLowerCase().equals("java")) {
                ScheduledFuture future = createJavaBatch(batchinfo);
                futures.add(future);
            } else {
                // TODO
                LOG.warn("batch type [" + batchinfo.getType() + "] is not impl.");
            }
        }
    }
    
    /**
     * Javaのバッチプログラムを呼び出す
     * @param batchinfo
     * @return
     */
    private ScheduledFuture createJavaBatch(Batchinfo batchinfo) {
        String envValue = SystemUtils.getenv(AppConfig.getEnvKey());
        String currentPath = AppConfig.get().getWebRealPath();
        File currentDirectory = new File(currentPath);
        
        int waitStart = (futures.size() * 2) + 1; // バッチの最初の起動は、Webアプリ起動の５分後で、かつバッチ毎に２分づつづらす
        
        ScheduledFuture future = service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("batch [" + batchinfo.getName() + "] was called.");
                }
                // Java を別のVMで実行
                JavaJob job = new JavaJob();
                job.setCurrentDirectory(currentDirectory);
                job.addjarDir(new File(AppConfig.get().getWebRealPath(), "lib"));
                job.addClassPathDir(new File(AppConfig.get().getWebRealPath(), "classes"));
                if (addTestClassDir) {
                    job.addClassPathDir(new File(AppConfig.get().getWebRealPath(), "test-classes"));
                }
                job.setMainClass(batchinfo.getCommand());
                if (StringUtils.isNotEmpty(envValue)) {
                    job.addEnvironment(AppConfig.getEnvKey(), envValue);
                }
                try {
                    JobResult result = job.execute();
                    if (LOG.isInfoEnabled()) {
                        LOG.info("finish batch [" + batchinfo.getName() + "]  [result code]" + result.getResultCode());
                    }
                    if (LOG.isTraceEnabled()) {
                        LOG.trace(result.getStdout());
                    }
                } catch (Exception e) {
                    LOG.error("Faild batch [" + batchinfo.getName() + "]", e);
                }
            }
        }, waitStart, batchinfo.getTerm(), TimeUnit.MINUTES); // 1分後に実行、60分毎に実行
        return future;
    }
    
    /**
     * 定期的なバッチ処理を終了
     */
    public void scheduleDestroy() {
        LOG.info("finish batch processes.");
        for (ScheduledFuture<?> scheduledFuture : futures) {
            try {
                scheduledFuture.cancel(true);
                scheduledFuture.get();
            } catch (Exception e) {
                LOG.debug("An error has occurred in the end processing of the batch", e); // 基本は無視でOK
            }
        }
        try {
            service.shutdown();
        } catch (Exception e) {
            LOG.debug("An error has occurred in the end processing of the batch", e); // 基本は無視でOK
        }
    }

    /**
     * @param addTestClassDir the addTestClassDir to set
     */
    public void setAddTestClassDir(boolean addTestClassDir) {
        this.addTestClassDir = addTestClassDir;
    }
    

}
