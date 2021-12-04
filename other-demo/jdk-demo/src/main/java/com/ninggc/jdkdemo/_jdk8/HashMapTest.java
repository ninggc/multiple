package com.ninggc.jdkdemo._jdk8;

import java.util.HashMap;
import java.util.concurrent.locks.LockSupport;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i);
        }

        LockSupport.park();
        System.out.println("end");
    }
}
