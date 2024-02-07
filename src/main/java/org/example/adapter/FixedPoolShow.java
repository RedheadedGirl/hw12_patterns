package org.example.adapter;

import org.example.proxy.ProxyFixedThreadPool;

import java.util.List;

public class FixedPoolShow implements PoolShow {
    @Override
    public void demonstrate(int amountOfThreads, List<Runnable> tasks) {
        ProxyFixedThreadPool fixedThreadPool = new ProxyFixedThreadPool(amountOfThreads);
        tasks.forEach(fixedThreadPool::execute);
        fixedThreadPool.start();
    }
}
