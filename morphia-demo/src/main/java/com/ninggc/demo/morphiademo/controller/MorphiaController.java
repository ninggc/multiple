package com.ninggc.demo.morphiademo.controller;

import com.ninggc.demo.morphiademo.morphia.dao.MorphiaQsAnswerDAO;
import com.ninggc.demo.morphiademo.morphia.domain.MorphiaQsAnswerPO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/morphia")
public class MorphiaController {
    @Resource
    private MorphiaQsAnswerDAO qsAnswerDAO;

    @GetMapping("/getList")
    public List<MorphiaQsAnswerPO> getList() {
        return qsAnswerDAO.findAll(0, 10);
    }
}
