package com.ninggc.multipledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MultipleDbApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MultipleDbApplication.class, args);
        Jedis jedis = new Jedis("localhost");
        String ping = jedis.ping();

        List<String> arrayList = new ArrayList();
        String[] strings = arrayList.toArray(new String[0]);
        jedis.lpush("list1", strings);
    }

    public static List<String> initList(long length) {
        return new ArrayList<>();
    }

}
