package com.ninggc.jdkdemo._extent;

public class Parent implements Base {
    static int i = 0;

    private void run() {
        System.out.println("child");
    }

    @Override
    public int getIt() {
        return i;
    }
}
