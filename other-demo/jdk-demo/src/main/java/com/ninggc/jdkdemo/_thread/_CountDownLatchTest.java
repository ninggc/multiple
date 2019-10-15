package com.ninggc.jdkdemo._thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author Ninggc
 * @create 2019-09-29 13:19
 * @description nothing
 */
public class _CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println("2");
            countDownLatch.countDown();
        }).start();
        System.out.println(3);
        countDownLatch.await();
        System.out.println(4);
    }
}
