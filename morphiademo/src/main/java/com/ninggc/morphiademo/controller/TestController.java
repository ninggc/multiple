package com.ninggc.morphiademo.controller;

import com.ninggc.morphiademo.morphia.dao.MorphiaQsAnswerDAO;
import com.ninggc.morphiademo.morphia.domain.MorphiaQsAnswerPO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {
    @Resource
    private MorphiaQsAnswerDAO qsAnswerDAO;

    @GetMapping("/test")
    public List<MorphiaQsAnswerPO> test() {
        List<MorphiaQsAnswerPO> all = qsAnswerDAO.findAll(0, 10);
        return all;
    }
}
