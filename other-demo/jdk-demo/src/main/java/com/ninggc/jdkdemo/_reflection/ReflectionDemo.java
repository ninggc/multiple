package com.ninggc.jdkdemo._reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ReflectionDemo {
    static final int count = 10 * 1000;

    public static void normal() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            objects.add(new ReflectionDemo());
        }

        // 55ms
        // ReflectionDemo reflectionDemo = new ReflectionDemo();
        // for (int i = 0; i < count; i++) {
        //     reflectionDemo.test();
        // }
    }

    public static void reflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ReflectionDemo> reflectionDemoClass = ReflectionDemo.class;
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            try {
                objects.add(reflectionDemoClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        // 95ms
        // ReflectionDemo reflectionDemo = new ReflectionDemo();
        // Method test = reflectionDemo.getClass().getMethod("test");
        //
        // for (int i = 0; i < count; i++) {
        //     test.invoke(reflectionDemo);
        // }
    }

    public void test() {
        System.out.println("t");
    }
}
