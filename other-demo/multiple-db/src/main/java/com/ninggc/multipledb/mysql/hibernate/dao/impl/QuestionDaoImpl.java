package com.ninggc.multipledb.mysql.hibernate.dao.impl;

import com.ninggc.multipledb.mysql.hibernate.dao.QuestionDao;
import com.ninggc.multipledb.mysql.hibernate.entity.QuestionEntity;
import com.ninggc.util.hibernatebase.HibernateBaseImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ninggc
 * @create 2019-10-14 11:11
 * @description nothing
 */
@Repository
@Transactional
public class QuestionDaoImpl extends HibernateBaseImpl<QuestionEntity> implements QuestionDao {
}
