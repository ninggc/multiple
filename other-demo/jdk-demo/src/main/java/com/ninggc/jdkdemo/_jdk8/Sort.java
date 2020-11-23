package com.ninggc.jdkdemo._jdk8;

import lombok.Data;
import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class Sort {
    public static void main(String[] args) throws Throwable {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<Object, Object>();
        int key = 0;
        while (key < 5 * 16) {
            map.put(key += 16, new String("hello"));
        }
        map.remove(key);


        // final List<Object> list = new ArrayList<>();
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // while (true) {
        //     executorService.submit(new Runnable() {
        //         @Override
        //         public void run() {
        //             list.add(new Object());
        //         }
        //     });
        // }

        // newIns();

    }

    private static void newIns() throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, CloneNotSupportedException {
        Number number = new Number();
        Number number1 = Number.class.newInstance();
        Number n2 = (Number) Number.class.getConstructors()[0].newInstance();
        Number n3 = number.clone();


        byte[] serialize = SerializationUtils.serialize(number);
        Object deserialize = SerializationUtils.deserialize(serialize);
    }

    public static void a() {
        while (true) {
            a();
        }
    }

    @Data
    static class Number implements Cloneable, Serializable {
        private int value;

        @Override
        public Number clone() throws CloneNotSupportedException {
            return (Number) super.clone();
        }
    }
}
