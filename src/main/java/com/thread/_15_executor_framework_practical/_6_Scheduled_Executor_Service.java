package com.thread._15_executor_framework_practical;

import java.util.concurrent.*;

public class _6_Scheduled_Executor_Service {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(() -> System.out.println("hello"), 1, TimeUnit.SECONDS);

        // it can overlap, no wait every 5 second it start new task.
        executor.scheduleAtFixedRate(() -> System.out.println("hello fixed rate"), 2, 5, TimeUnit.SECONDS);

        // no overlap, it waits to complete before starting next one.
        executor.scheduleWithFixedDelay(() -> System.out.println("hello fixed delay"), 2, 5, TimeUnit.SECONDS);

        executor.schedule(executor::shutdown, 20, TimeUnit.SECONDS);
    }
}
