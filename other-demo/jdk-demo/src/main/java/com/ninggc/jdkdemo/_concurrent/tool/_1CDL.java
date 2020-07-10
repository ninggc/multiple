package com.ninggc.jdkdemo._concurrent.tool;

import java.util.concurrent.CountDownLatch;

public class _1CDL {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();

        System.out.println("end");
    }
}
