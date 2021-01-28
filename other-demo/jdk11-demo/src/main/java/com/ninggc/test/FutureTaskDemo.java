package com.ninggc.test;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Callable<String> callable = new Callable<>() {
            @Override
            public String call() throws Exception {
                countDownLatch.countDown();
                Thread.sleep(10 * 1000);
                return "sorry to keep you waiting";
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> task = new FutureTask<>(callable);
        Future<?> submit = executorService.submit(task);
        Thread.sleep(1 * 1000);
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                countDownLatch.await();
                task.cancel(true);
            }
        }.start();
        System.out.println(submit.get());


        // System.out.println(submit.get());
        //
        // CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
        //     @SneakyThrows
        //     @Override
        //     public String get() {
        //         return callable.call();
        //     }
        // });
        // String msg = future.get();
    }
}
