package com.thread._15_executor_framework_practical;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class _5_InvokeAny {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello";
        Callable<String> callable2 = () -> "Hello 2";
        Callable<String> callable3 = () -> "Hello 3";

        String result = executorService.invokeAny(Arrays.asList(callable, callable2, callable3));
        System.out.println(result);
        executorService.shutdown();
    }
}
