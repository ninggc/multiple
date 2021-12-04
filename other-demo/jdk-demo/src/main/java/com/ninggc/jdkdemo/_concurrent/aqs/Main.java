package com.ninggc.jdkdemo._concurrent.aqs;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
    }

    public void a() {
        int a = 1;
    }

    public void b() {
        int a = 1;
        int b = 2;
    }

    public void c() {
        int a = 1;
        Integer c = null;
    }

    public void d() {
        int a = 1;
        Object d = new Object();
    }
}
