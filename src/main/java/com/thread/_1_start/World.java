package com.thread._1_start;

public class World extends Thread{

    @Override
    public void run() {
        for(;;) {
            System.out.println("world");
        }
    }
}