package com.ninggc.jdkdemo._thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Ninggc
 * @create 2019-09-29 13:28
 * @description nothing
 */
public class _CyclicBarrier {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println(0));

        Thread thread = new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        });
        thread.start();

        cyclicBarrier.await();
        System.out.println(2);
    }
}
