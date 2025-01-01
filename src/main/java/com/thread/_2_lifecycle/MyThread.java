package com.thread._2_lifecycle;

/**
 * In this class you will see all thread state example.
 * NEW, RUNNABLE, RUNNING, BLOCKED/WAITING & TERMINATED
 * */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        sleep(100);
        System.out.println(t1.getState());
        t1.join(); // waits for t1 thread to terminate.
        System.out.println(t1.getState());

    }
}
