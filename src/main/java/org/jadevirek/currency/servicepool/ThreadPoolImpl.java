//package org.jadevirek.currency.servicepool;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//import static java.lang.Thread.sleep;
//
//public class ThreadPoolImpl implements ThreadPoolInterface{
//
//    private final BlockingQueue<GenericRunner> queueOfTasks;
//    private final List<? extends GenericRunner>  runnables = new ArrayList<>();
//    private boolean isStopped = false;
//
//    public ThreadPoolImpl(int numbOfThreads, int maxSize) {
//            this.queueOfTasks = new ArrayBlockingQueue<GenericRunner>(maxSize);
//    }
//
//    @Override public void execute(GenericRunner task) {
//        if(this.isStopped) throw
//                new IllegalStateException("ThreadPool is stopped");
//
//        this.queueOfTasks.offer(task);
//    }
//
//  @Override
//  public void execute(Runnable task) {
//
//  }
//
//  @Override public void stopPool() {
//        this.isStopped =true;
//        for(GenericRunner runnable : runnables){
//            runnable.stopRunning();
//        }
//    }
//
//    @Override public synchronized void waitUntilAllTasksFinished() {
//        while(this.queueOfTasks.size() > 0) {
//            try {
//                sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
