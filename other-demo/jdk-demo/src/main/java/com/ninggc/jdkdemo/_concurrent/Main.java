package com.ninggc.jdkdemo._concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread.sleep(5 * 1000);

        // while (true) {
        //     executorService.execute(new Runnable() {
        //         @Override
        //         public void run() {
        //             while (true) {
        //                 Thread.yield();
        //             }
        //         }
        //     });
        // }

        String s = "";
        for (int i = 0; i < 1000000; i++) {
            s += "a";
            if (i % 10000 == 0) {
                System.gc();
            }
        }
    }

    private static String test(String s) {
        String a = s + s;
        return a;
    }
}
