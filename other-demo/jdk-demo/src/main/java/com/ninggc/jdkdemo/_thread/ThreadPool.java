package com.ninggc.jdkdemo._thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.execute(
                    () -> {
                        // ... do something inside runnable task
                        System.out.println(finalI);
                    });
            // service.submit()
        }


        while (true) {
            if (service.isTerminated()) {
                break;
            }
        }

    }
}
