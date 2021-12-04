package com.ninggc.jdkdemo._concurrent.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ObjectWaitPrinter {
    volatile static List monitor = new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (monitor.size() < 10) {
                synchronized (monitor) {
                    monitor.add(1);
                    System.out.println(monitor.size());
                    try {
                        monitor.notifyAll();
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (monitor.size() < 10) {
                synchronized (monitor) {
                    char x = (char) ('A' + monitor.size() - 1);
                    System.out.println(x);
                    monitor.notifyAll();
                    // thread.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        // thread.setDaemon(true);
        thread.start();
        // thread1.setDaemon(true);
        thread1.start();

        // Thread.sleep(10 * 1000);
    }
}
