package com.ninggc.jdkdemo._concurrent.tool;

import java.util.concurrent.Semaphore;
import lombok.SneakyThrows;

public class _3Semaphore {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(finalI + "before");
                        System.out.println(finalI + "after");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        System.out.println("end");
    }
}
