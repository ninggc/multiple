package com.ninggc.multipledb.mysql.hibernate.web;

import com.ninggc.multipledb.mysql.hibernate.config.DeleteEnum;
import com.ninggc.multipledb.mysql.hibernate.dao.QuestionDao;
import com.ninggc.multipledb.mysql.hibernate.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description nothing
 * @author ninggc
 * @create 2019-10-14 17:56
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/throw")
    public void throwException() throws Exception {
        throw new Exception("抛出异常测试");
    }

    @GetMapping("/all")
    public List<QuestionEntity> allQuestion() {
        return questionDao.findAll();
    }

    @GetMapping("/save")
    public QuestionEntity save() {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setDeleteFlag(DeleteEnum.YES);
        QuestionEntity save = questionDao.save(questionEntity);
        return save;
    }
}
