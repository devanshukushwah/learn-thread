package com.thread._9_read_write_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * main outcome of this implementation while reading all reader thread will get same result.
 * */
public class ReadWriteLockExample {

    private static int count = 0;

    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final Lock readLock = readWriteLock.readLock();

    private static final Lock writeLock = readWriteLock.writeLock();

    private void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getMyCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + readWriteLockExample.getMyCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    readWriteLockExample.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            }
        };

        Thread tw = new Thread(writeTask, "Write Thread");
        Thread tr1 = new Thread(readTask, "Read Thread 1");
        Thread tr2 = new Thread(readTask, "Read Thread 2");

        tw.start();
        tr1.start();
        tr2.start();

    }

}
