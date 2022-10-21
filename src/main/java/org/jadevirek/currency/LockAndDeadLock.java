package org.jadevirek.currency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockAndDeadLock {

    public static void main(String[] args) {
        // create ten reader threads
//        for (int i=0; i<10; i++)
//            new CalendarUser("Reader-"+i).start();
//
//        // ...but only two writer threads
//        for (int i=0; i<2; i++)
//            new CalendarUser("Writer-"+i).start();

        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        new Philosopher("Barron", chopstickA, chopstickB).start();
        new Philosopher("Olivia", chopstickB, chopstickC).start();
        // Deadlock by line under.
//        new Philosopher("Steve", chopstickC, chopstickA).start();
        // Make it priority.
        new Philosopher("Steve", chopstickA, chopstickC).start();
    }
}



class CalendarUser extends Thread {

    private static final String[] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static int today = 0;
    private static final ReentrantReadWriteLock wRlock = new ReentrantReadWriteLock();
    private static final Lock readLock  = wRlock.readLock();
    private static final Lock writeLock  = wRlock.writeLock();

    public CalendarUser(String name) {
        this.setName(name);
    }

    public void run() {
        while (today < WEEKDAYS.length-1){
            if (this.getName().contains("Writer")) { // update the shared calendar
                writeLock.lock();
                try {
                    today = (today+1) % 7;
                    System.out.println(this.getName() + " updated date to " + WEEKDAYS[today]);
                } catch (Exception e)
                {e.printStackTrace(); }
                {
                    writeLock.unlock();
                }
            } else { // Reader - check to see what today is
                readLock.lock();
                try {
                    System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today]);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        }
    }
}
class Philosopher extends Thread {

    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 100000;

    public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while (sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

            // take a piece of sushi
            if (sushiCount > 0) {
                sushiCount--;
                System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
            }

            // put down chopsticks
            secondChopstick.unlock();
            firstChopstick.unlock();
        }
    }

}
