package com.thread._3_methods;

/**
 * start run sleep join setPriority interrupt yield setDaemon
 * */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("thread is running....");

        try {
            Thread.yield(); // to hint thread scheduler to give chance other thread to run.
            Thread.sleep(2000);
            System.out.println("Thread is running....");
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted " + e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
//        t.run(); // contain code of instruction
        t.start(); // to start thread
//        Thread.sleep(1000); // to make current thread to wait
//        t.join(); // to wait for finish t thread.

        // Thread priority is like a hint to JVM.
        t.setPriority(Thread.MIN_PRIORITY); // to set lowest priority
        t.setPriority(Thread.NORM_PRIORITY); // to set medium priority
        t.setPriority(Thread.MAX_PRIORITY); // to set highest priority

//        t.interrupt();
        t.setDaemon(true); // to run thread in background.


    }
}
