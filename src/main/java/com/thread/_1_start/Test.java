package com.thread._1_start;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test start");

        World world = new World(); // NEW - thread created but not yet started.
        world.start(); // RUNNABLE - thread is ready to run and waiting for CPU time.
        // RUNNING - thread is in this state when it is executing.
        // BLOCKED/WAITING - thread is in this state when waiting for resource or for another thread to perform an action.
        // TERMINATED - thread is in this state when it has finished execution.

        for(;;) {
            System.out.println("hello");
        }
    }
}
