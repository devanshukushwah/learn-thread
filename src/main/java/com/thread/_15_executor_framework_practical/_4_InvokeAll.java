package com.thread._15_executor_framework_practical;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class _4_InvokeAll {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello";
        Callable<String> callable2 = () -> "Hello 2";
        Callable<String> callable3 = () -> "Hello 3";

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(callable, callable2, callable3));
        for(Future<String> f: futures) {
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
}
