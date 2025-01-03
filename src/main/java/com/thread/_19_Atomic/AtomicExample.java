package com.thread._19_Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicExample atomicExample = new AtomicExample();
        Thread i1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicExample.increment();
            }
        });
        Thread i2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicExample.increment();
            }
        });

        i1.start();
        i2.start();
        i1.join();
        i2.join();
        System.out.println(atomicExample.getCounter());
    }
}
