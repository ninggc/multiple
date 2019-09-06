package com.ninggc.demo.morphiademo.morphia.domain;

import org.bson.Document;

public interface IMorphiaPO {
    /**
     * 将po转换成可以存储的Document,在事务操作中使用
     * 等到Morphia支持事务时重构这部分
     * @return
     */
    Document toDocument();
}
