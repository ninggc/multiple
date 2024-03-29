package com.ninggc.jdkdemo._concurrent.tool;

import java.util.concurrent.CountDownLatch;

public class _1CDL {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (countDownLatch) {
                        System.out.println(finalI);
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }

        System.out.println("end");
        countDownLatch.await();
        System.out.println("end");
    }
}
