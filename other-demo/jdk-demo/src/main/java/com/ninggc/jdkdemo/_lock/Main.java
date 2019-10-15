package com.ninggc.jdkdemo._lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {
    static class Sync extends AbstractQueuedSynchronizer {
    }

    public static Sync getInstance() {
        return new Sync();
    }
}
