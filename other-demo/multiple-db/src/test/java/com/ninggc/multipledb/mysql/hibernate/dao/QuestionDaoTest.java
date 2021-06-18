package com.ninggc.multipledb.mysql.hibernate.dao;

import com.ninggc.multipledb.MultipleDbApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionDaoTest extends MultipleDbApplicationTests {

    @Autowired private QuestionDao questionDao;

    @Test
    public void save() {

    }

    @Test
    public void list() {
        questionDao.findAll();
    }
}