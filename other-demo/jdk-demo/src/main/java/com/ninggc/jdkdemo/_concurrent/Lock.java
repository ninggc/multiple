package com.ninggc.jdkdemo._concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    static ExecutorService executorService = Executors.newCachedThreadPool();
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Integer a = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    // synchronized (a) {
                    //     System.out.print(++a + "\t");
                    // }

                    try {
                        Thread.sleep(2 * 1000);
                        Thread.yield();
                        reentrantLock.lock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (reentrantLock.isLocked()) {
                            reentrantLock.unlock();
                        }
                    }

                }
            });
        }
    }
}
