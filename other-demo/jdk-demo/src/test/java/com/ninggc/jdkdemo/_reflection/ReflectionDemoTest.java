package com.ninggc.jdkdemo._reflection;

import java.lang.reflect.InvocationTargetException;

class ReflectionDemoTest {

    @org.junit.jupiter.api.Test
    void normal() {
        ReflectionDemo.normal();
    }

    @org.junit.jupiter.api.Test
    void reflection() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ReflectionDemo.reflection();
    }
}