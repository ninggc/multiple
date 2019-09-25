package com.ninggc.multipledb;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class RedisTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    List<String> list4 = new ArrayList<>();
    Jedis jedis;

    Long _1WW = 100000000L;
    Long _5KW = 50000000L;

    @Before
    public void before() {
        System.out.println(sdf.format(new Date()));
        System.out.println("初始化数据");

        for (Long l = _1WW; l < _1WW + 100; l++) {
            list1.add(String.valueOf(l));
        }
        for (Long l = _1WW + _5KW; l < _1WW + 100; l++) {
            list2.add(String.valueOf(l));
        }
//        for (Long l = 10000000005000000L; l < 10000000015000000L; l++) {
//            list3.add(String.valueOf(l));
//        }
//        for (Long l = 10000000005000000L; l < 10000000015000000L; l++) {
//            list4.add(String.valueOf(l));
//        }
        System.out.println("初始化数据结束");
        jedis = new Jedis("localhost");
        System.out.println("连接jedis");
    }

    public void lPushList(String key, List<String> list) {
        jedis.lpush(key, list.toArray(new String[0]));
    }

    @Test
    public void test() {
        System.out.println("推到redis");
        lPushList("one", list1);
        lPushList("two", list2);
        lPushList("three", list3);
        lPushList("four", list4);
        System.out.println("推送结束");

        System.out.println("取交集");
        Set<String> sinter = jedis.sinter("one", "two");
        System.out.println("取交集 end");
    }

}