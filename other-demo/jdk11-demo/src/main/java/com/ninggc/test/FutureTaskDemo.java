package com.ninggc.test;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2 * 1000);
                return "sorry to keep you waiting";
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(callable);

        System.out.println(submit.get());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                return callable.call();
            }
        });
        String msg = future.get();
    }
}
