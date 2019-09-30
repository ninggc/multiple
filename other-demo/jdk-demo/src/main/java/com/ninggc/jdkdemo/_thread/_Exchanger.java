package com.ninggc.jdkdemo._thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ninggc
 * @create 2019-09-29 15:08
 * @description nothing
 */
public class _Exchanger {

    static Exchanger<String> exchanger = new Exchanger<>();
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            String A = "ExA";
            try {
                exchanger.exchange(A);
                System.out.println("t1" + A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            String B = "ExB";
            System.out.println("t2" + B);
            try {
                String A = exchanger.exchange("A");
                System.out.println("t2" + A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
