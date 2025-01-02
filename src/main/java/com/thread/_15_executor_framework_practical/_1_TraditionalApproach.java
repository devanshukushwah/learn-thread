package com.thread._15_executor_framework_practical;

public class _1_TraditionalApproach {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[9];

        for (int i = 1; i< 10; i++ ) {
            int finalI = i;
            threads[i - 1] = new Thread(()-> {
                long value = factorial(finalI);
                System.out.println(value);
            });
            threads[i - 1].start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
