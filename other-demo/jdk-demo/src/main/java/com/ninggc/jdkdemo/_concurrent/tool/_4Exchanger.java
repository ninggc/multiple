package com.ninggc.jdkdemo._concurrent.tool;

import java.util.concurrent.Exchanger;

public class _4Exchanger {
    public static void main(String[] args) throws InterruptedException {

        Exchanger<Integer> exchanger = new Exchanger<>();

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @lombok.SneakyThrows
                @Override
                public void run() {
                    exchanger.exchange(finalI);
                }
            }).start();
        }


        System.out.println("end");
    }
}
