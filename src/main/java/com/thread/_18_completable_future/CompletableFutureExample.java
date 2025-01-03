package com.thread._18_completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("worker");
            } catch (Exception ex) {

            }
            return "ok";
        });
        stringCompletableFuture.join();
        System.out.println("Main");
    }
}
