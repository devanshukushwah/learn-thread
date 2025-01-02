package com.thread._15_executor_framework_practical;

import java.util.concurrent.*;

public class _3_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello";

        Future<String> submit = executorService.submit(callable);
        System.out.println(submit.get());
        if (submit.isDone()) {
            System.out.println("task complete");
        }
        executorService.shutdown();
    }

    /*
     * Runnable vs Callable.
     * 1. runnable not return value but callable return some value.
     * 2. method name is different run for runnable and call for callable.
     * 3. signature Runnable not throws exception but Callable throws Exception.
     * */
}
