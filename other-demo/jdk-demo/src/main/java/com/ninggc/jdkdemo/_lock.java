package com.ninggc.jdkdemo;

import java.util.concurrent.locks.ReentrantLock;

public class _lock {


    static ReentrantLock lock1 = new Lock("l1");
    static ReentrantLock lock2 = new Lock("l2");

    public static void main(String[] args) {
        Thread t1 = new Thread("test1") {
            @Override
            public void run() {
                super.run();
                lock1.lock();
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lock();
                lock1.unlock();
                lock2.unlock();
            }
        };
        t1.start();

        Thread t2 = new Thread("test2") {
            @Override
            public void run() {
                super.run();
                lock2.lock();
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lock();
                lock2.unlock();
                lock1.unlock();
            }
        };
        t2.start();
    }

    static class Lock extends ReentrantLock {
        String name;

        public Lock(String name) {
            super();
            this.name = name;
        }

        @Override
        public void lock() {
            super.lock();
            System.out.println(name + "-lock");
        }

        @Override
        public void unlock() {
            super.unlock();
            System.out.println(name + "-unlock");
        }
    }
}
