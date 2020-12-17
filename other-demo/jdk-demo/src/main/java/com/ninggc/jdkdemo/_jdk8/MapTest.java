package com.ninggc.jdkdemo._jdk8;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        tableSizeFor(1);
        tableSizeFor(3);
        tableSizeFor(9);

        Map m = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            m.put(i * 16, i * 16);
        }
    }

    static final int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
