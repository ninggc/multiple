package com.ninggc.test;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // var a = 1;
        // var b = 2L;
        // var c = "123";
        // var d = new Object();
        //
        //
        // System.out.println("===");
        // System.out.println("\"\" = " + "");
        //
        // Predicate.not(new Predicate<Object>() {
        //     @Override
        //     public boolean test(Object o) {
        //         return false;
        //     }
        // });


        String s = "!@#$%^*(&@#)(<>?:}{}_+|";

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(s.charAt(random.nextInt(s.length())));
        }

        System.out.println(stringBuilder.toString());
    }
}
