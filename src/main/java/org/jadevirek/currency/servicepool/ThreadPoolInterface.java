package org.jadevirek.currency.servicepool;

public interface ThreadPoolInterface {
    void execute(Runnable task);
    void stopPool();
    void waitUntilAllTasksFinished();
}
