package com.thread._6_why_reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        try{
            System.out.println("outer");
            inner();
        } finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock();
        try {
            System.out.println("inner");
        } finally {
            lock.unlock();
        }
    }
}
