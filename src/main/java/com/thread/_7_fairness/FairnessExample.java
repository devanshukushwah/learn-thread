package com.thread._7_fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Fair Lock:
 *
 * Ensures that the longest-waiting thread gets the lock next.
 * Prevents thread starvation because every thread gets its turn in the order of requests.
 * Fair locks can be less efficient because of the overhead of maintaining the order.
 *
 * Non-Fair Lock:
 *
 * Threads may acquire the lock out of order, allowing threads that are ready to compete for the lock to get it immediately.
 * Can lead to higher throughput in heavily contended scenarios but increases the chance of starvation for some threads.
 * */
public class FairnessExample {

    private final Lock lock = new ReentrantLock(true);

    void accessResource() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock");
        }
    }

    public static void main(String[] args) {
        FairnessExample fairnessExample = new FairnessExample();
        Runnable task = fairnessExample::accessResource;

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
