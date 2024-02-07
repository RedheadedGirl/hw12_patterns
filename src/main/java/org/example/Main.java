package org.example;

import org.example.adapter.FixedPoolShow;
import org.example.exception.SettingException;
import org.example.proxy.ProxyScalableThreadPool;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SettingException {
        fixedThreadPool();
//        scalableThreadPool();
    }

    private static void fixedThreadPool() {
        FixedPoolShow show = new FixedPoolShow();
        show.demonstrate(3, List.of(getRunnable(1), getRunnable(2), getRunnable(3)));
    }

    private static void scalableThreadPool() throws SettingException {
        ProxyScalableThreadPool scalableThreadPool = new ProxyScalableThreadPool(2, 3);
        scalableThreadPool.execute(getRunnable(1));
        scalableThreadPool.execute(getRunnable(2));
        scalableThreadPool.execute(getRunnable(3));
        scalableThreadPool.start();

        addLastTask(scalableThreadPool);
    }

    private static Runnable getRunnable(int number) {
        return () -> {
            System.out.println(number + "!!!");
            System.out.println("Выполняется " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Заканчивается " + Thread.currentThread().getName());
        };
    }

    private static void addLastTask(ThreadPool threadPool) {
        try {
            System.out.println("sleep for task 4 started");
            Thread.sleep(10000);
            System.out.println("sleep for task 4 finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.execute(getRunnable(4));
        }
    }
}