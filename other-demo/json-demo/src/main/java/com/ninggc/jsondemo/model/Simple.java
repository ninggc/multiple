package com.ninggc.jsondemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 简单对象
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/6/17 10:38
 * @version:v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Simple {
    private String s;
    private Long l;
    private Object o;

    public static final transient Simple INSTANCE;
    public static final transient String JSON;


    static {
        //language=JSON
        JSON = "{\"s\":\"s\",\"l\":0,\"o\":{}}";
        INSTANCE = new Simple("s", 0L, new Object());
    }

}
