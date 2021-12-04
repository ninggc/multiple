package com.ninggc.jdkdemo._jvm;

/**
 * @author ninggc
 * @description
 * @date 2020-09-21 16:13
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(Sington.a);
        System.out.println(Sington.b);
    }
}

class Sington {
    static int a;
    static Sington sington = new Sington();
    static int b = 0;

    private Sington() {
        a++;
        b++;
        System.out.println("a" + a);
        System.out.println("b" + b);
    }
}