package com.thread._4_synchronization;

public class Counter {
    private int count = 0;


    // this section is critical because it is used by multiple thread.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
