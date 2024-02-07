package org.example.proxy;

import org.example.FixedThreadPool;
import org.example.ScalableThreadPool;
import org.example.ThreadPool;
import org.example.exception.SettingException;

import java.util.logging.Logger;

/**
 * Данный прокси предназанчен для логирования вызова методов
 */
public class ProxyScalableThreadPool implements ThreadPool {

    private final ScalableThreadPool scalableThreadPool;

    private final Logger logger = Logger.getLogger("ProxyScalableThreadPool");

    public ProxyScalableThreadPool(int minAmountOfThreads, int maxAmountOfThreads) throws SettingException {
        this.scalableThreadPool = new ScalableThreadPool(minAmountOfThreads, maxAmountOfThreads);
    }

    @Override
    public void start() {
        logger.info("start method was called");
        scalableThreadPool.start();
    }

    @Override
    public void execute(Runnable runnable) {
        logger.info("execute method was called");
        scalableThreadPool.execute(runnable);
    }
}
