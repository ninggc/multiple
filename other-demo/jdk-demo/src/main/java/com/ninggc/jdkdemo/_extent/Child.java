package com.ninggc.jdkdemo._extent;

public class Child extends Parent {
    static int i = 1;

    private void run() {
        System.out.println("parent");
    }

    @Override
    public int getIt() {
        return i;
    }
}
