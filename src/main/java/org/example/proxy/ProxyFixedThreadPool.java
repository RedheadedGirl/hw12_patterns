package org.example.proxy;

import org.example.FixedThreadPool;
import org.example.ThreadPool;

import java.util.logging.Logger;

/**
 * Данный прокси предназанчен для логирования вызова методов
 */
public class ProxyFixedThreadPool implements ThreadPool {

    private final FixedThreadPool fixedThreadPool;

    private final Logger logger = Logger.getLogger("ProxyFixedThreadPool");

    public ProxyFixedThreadPool(int amountOfThreads) {
        this.fixedThreadPool = new FixedThreadPool(amountOfThreads);
    }

    @Override
    public void start() {
        logger.info("start method was called");
        fixedThreadPool.start();
    }

    @Override
    public void execute(Runnable runnable) {
        logger.info("execute method was called");
        fixedThreadPool.execute(runnable);
    }
}
