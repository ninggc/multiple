package com.ninggc.jdkdemo._thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Ninggc
 * @create 2019-09-29 14:55
 * @description nothing
 */
public class _Semaphore {
    static Semaphore semaphore = new Semaphore(2);
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(finalI);
//                    if (true) {
//                        throw new Exception();
//                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    semaphore.release();
                }
            });
        }
    }
}
