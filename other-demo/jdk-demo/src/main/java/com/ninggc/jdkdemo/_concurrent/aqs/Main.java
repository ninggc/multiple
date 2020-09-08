package com.ninggc.jdkdemo._concurrent.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static class Sync extends AbstractQueuedSynchronizer {
    }

    public static Sync getInstance() {
        return new Sync();
    }

    public static void main(String[] args) {
        synchronized (Main.class) {
            ReentrantLock lock;
        }
    }
}
