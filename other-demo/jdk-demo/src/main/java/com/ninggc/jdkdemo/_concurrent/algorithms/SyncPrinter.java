package com.ninggc.jdkdemo._concurrent.algorithms;

public class SyncPrinter extends Thread {
    volatile static Integer monitor = 0;
    volatile static Boolean s = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (monitor < 10) {
                if (s) {
                    ++monitor;
                    System.out.println(monitor);
                    s = !s;
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (monitor < 10) {
                if (!s) {
                    char x = (char) ('A' + monitor - 1);
                    System.out.println(x);
                    s = !s;
                }
            }
        });


        // thread.setDaemon(true);
        thread.start();
        // thread1.setDaemon(true);
        thread1.start();

        // Thread.sleep(10 * 1000);
    }

    public void print() {
        new SyncPrinter().start();
    }

    @Override
    public void run() {
    }
}
