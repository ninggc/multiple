package com.ninggc.multipledb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RedisTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Set<String> list1 = new HashSet<>();
    Set<String> list2 = new HashSet<>();
    Set<String> list3 = new HashSet<>();
    Set<String> list4 = new HashSet<>();
    Jedis jedis;
    Set<String> sinter;

    final Long _1WW = 100000000L;
    final Long _5KW = 50000000L;
    final Long _1M = 1000000L;
    final Long _2M = 2000000L;

    void logTime() {
        System.out.println(sdf.format(new Date()));
//        System.out.println(System.currentTimeMillis());
    }

    @Before
    public void before() {
        logTime();
        System.out.println("初始化数据");

        Long start = _1WW;
        Long length = 1000000L;
        for (Long l = start; l < start + length; l++) {
            list1.add(String.valueOf(l));
        }
        start = _1WW + _1M / 2;
        for (Long l = start; l < start + length; l++) {
            list2.add(String.valueOf(l));
        }
//        start = _1WW + _1M * 2;
//        for (Long l = start; l < start + length; l++) {
//            list3.add(String.valueOf(l));
//        }
//        start = _1WW + _1M * 3;
//        for (Long l = start; l < start + length; l++) {
//            list4.add(String.valueOf(l));
//        }

        System.out.println("初始化数据结束");
        logTime();
        jedis = new Jedis("10.1.192.190");
        System.out.println("连接jedis");
    }

    public void saddSet(String key, Set<String> list) {
//        Pipeline pipelined = jedis.pipelined();
//        for (int i = 0; i < list.size(); i++) {
//        }
//        pipelined.sync();
        jedis.sadd(key, list.toArray(new String[0]));
    }

    @Test
    public void test() {
        logTime();
        System.out.println("推到redis");
        saddSet("one", list1);
        saddSet("two", list2);
//        lPushList("three", list3);
//        lPushList("four", list4);
        System.out.println("推送结束");
        logTime();

        System.out.println("取交集");
        sinter = jedis.sinter("one", "two");
        System.out.println("取交集 end");
        logTime();
    }

    @After
    public void after() {
        jedis.close();
    }
}