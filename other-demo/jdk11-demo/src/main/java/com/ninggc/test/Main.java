package com.ninggc.test;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        var a = 1;
        var b = 2L;
        var c = "123";
        var d = new Object();


        System.out.println("===");
        System.out.println("\"\" = " + "");

        Predicate.not(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        })
    }
}
