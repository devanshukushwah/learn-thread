package com.thread._5_manuallock;

import com.thread._2_lifecycle.MyThread;

/** (use Automatic lock with the help of synchronized keyword)
 * synchronized keyword: use to ensure only one thread should execute critical code
 *                       also called as mutual exclusion.
 *
 * Race condition: when multiple thread working on shared resources
 *                 and there timing is different because of this output
 *                 is unpredictable is known as Race condition.
 * */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bank.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}
