package com.ninggc.jdkdemo._concurrent.tool;

import java.util.concurrent.Semaphore;

public class _3Semaphore {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @lombok.SneakyThrows
                @Override
                public void run() {
                    semaphore.acquire();
                    System.out.println(finalI + "before");
                    System.out.println(finalI + "after");
                    semaphore.release();
                }
            }).start();
        }


        System.out.println("end");
    }
}
