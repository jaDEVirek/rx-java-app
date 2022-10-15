package org.jadevirek.currency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyComputing {

    public static void main(String[] args) {
        final Thread computingTask = new Thread(new ComputingTask());
        final Thread computingTask2 = new Thread(new ComputingTask());
        computingTask.start();
        computingTask2.start();
    }
}

class ComputingTask implements Runnable {
    private static Lock innerLock = new ReentrantLock();
    // Synchronized on class lvl is better
    // Synchronize on object lvl cause un-atomic results.
    // So still object members, not class members are sheared by each process on its own.
    private static int sumOfCounting;
    private static final AtomicInteger atomicType = new AtomicInteger(0);
    @Override public void run() {
       ;
        for (int i = 0; i < 10; i++) {
            //minimize critical section
            innerLock.lock();
            sumOfCounting++;
            innerLock.unlock();
            atomicType.incrementAndGet();
            // Still is better to use Atomic version.
            System.out.println(Thread.currentThread().getName() + " is processing.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicType);
        System.out.println("non atomic " + sumOfCounting);
    }
}
