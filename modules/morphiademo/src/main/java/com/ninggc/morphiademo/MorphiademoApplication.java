package com.ninggc.morphiademo;

import com.ninggc.morphiademo.morphia.dao.MorphiaQsAnswerDAO;
import com.ninggc.morphiademo.morphia.domain.MorphiaQsAnswerPO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring/applicationContext.xml"})
public class MorphiademoApplication {

    @Resource
    private MorphiaQsAnswerDAO morphiaQsAnswerDAO;

    public static void main(String[] args) {
        SpringApplication.run(MorphiademoApplication.class, args);

        MorphiademoApplication morphiademoApplication = new MorphiademoApplication();
        List<MorphiaQsAnswerPO> all = morphiademoApplication.morphiaQsAnswerDAO.findAll(0, 10);
    }
}
