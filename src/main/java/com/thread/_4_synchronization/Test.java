package com.thread._4_synchronization;

/** (use Automatic lock with the help of synchronized keyword)
 * synchronized keyword: use to ensure only one thread should execute critical code
 *                       also called as mutual exclusion.
 *
 * Race condition: when multiple thread working on shared resources
 *                 and there timing is different because of this output
 *                 is unpredictable is known as Race condition.
 * */
public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(counter.getCount());
    }
}
