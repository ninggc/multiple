package com.ninggc.jdkdemo._concurrent.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class _2CyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            String name = Thread.currentThread().getName();
            while (true) {
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("my name is " + name);
            }
        });

        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                try {
                    System.out.println(finalI + "before");
                    cyclicBarrier.await();
                    // if (finalI != 0) {
                    //     threads[finalI - 1].join();
                    // }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI + "after");
            }, "MyThread" + i);
            threads[i].start();
        }


        System.out.println("end");
    }
}
