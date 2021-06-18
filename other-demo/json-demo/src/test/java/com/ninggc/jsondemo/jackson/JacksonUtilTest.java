package com.ninggc.jsondemo.jackson;

import com.ninggc.jsondemo.model.Simple;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;


/**
 * @description: jacksonUtils测试
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/6/17 10:31
 * @version:v1.0
 */
class JacksonUtilTest {

    @org.junit.jupiter.api.Test
    void readValue() {
        Optional<Simple> optionalT = JacksonUtil.readValue(Simple.JSON, Simple.class);
        Assertions.assertTrue(optionalT.isPresent(), "optionalT not present");
    }

    @org.junit.jupiter.api.Test
    void writeValueAsString() {
        String json = JacksonUtil.writeValueAsString(Simple.INSTANCE);
        Assertions.assertEquals(json, Simple.JSON);
    }
}