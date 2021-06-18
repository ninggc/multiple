package com.ninggc.multipledb.mysql.hibernate.dao.impl;

import com.ninggc.multipledb.mysql.hibernate.dao.QuestionDao;
import com.ninggc.multipledb.mysql.hibernate.entity.QuestionEntity;
import com.ninggc.util.hibernatebase.HibernateBaseImpl;
import org.springframework.stereotype.Repository;

/**
 * @author Ninggc
 * @create 2019-10-14 11:11
 * @description nothing
 */
@Repository
public class QuestionDaoImpl extends HibernateBaseImpl<QuestionEntity> implements QuestionDao {
}
