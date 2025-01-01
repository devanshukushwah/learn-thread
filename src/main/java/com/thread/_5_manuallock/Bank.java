package com.thread._5_manuallock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int balance = 100;

    Lock lock = new ReentrantLock();

    /**
     * lock methods:
     *              lock() - its lock the thread and block thread to do next operation.
     *              tryLock() - Acquires the lock only if it is free at the time of invocation.
     *              tryLock(1, TimeUnit.SECONDS) - Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
     *              unlock() - to release lock.
     *
     * */
    // this section is critical because it is used by multiple thread.
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempt to withdraw " + amount);
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                if(amount <= balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " initializing withdrawal");
                        Thread.sleep(3000);
                        balance = balance - amount;
                        System.out.println(Thread.currentThread().getName() + " withdraw complete available balance " + balance);
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " Not sufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to acquire lock");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // good practice to inform monitor services.
            throw new RuntimeException(e);
        }
    }

    public int getBalance() {
        return balance;
    }
}
