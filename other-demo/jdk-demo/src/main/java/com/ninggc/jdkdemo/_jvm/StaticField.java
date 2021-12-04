package com.ninggc.jdkdemo._jvm;

public class StaticField {
    public static final int a = 1;
    public static int b = 2;

    static {
        b = 3;
    }

    public static void main(String[] args) {
        System.out.println(StaticField.b);
    }
}
