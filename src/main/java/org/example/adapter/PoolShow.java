package org.example.adapter;

import java.util.List;

/**
 * Предположим, что для демонстрации работы потоков нам НУЖЕН такой интерфейс, где все действия будут выполнены в одном
 * методе
 */
public interface PoolShow {

    /**
     * Метод, который принимает сразу список задач, добавляет их в очередь, запускает
     * @param amountOfThreads количество потоков
     * @param tasks список задач
     */
    void demonstrate(int amountOfThreads, List<Runnable> tasks);
}
