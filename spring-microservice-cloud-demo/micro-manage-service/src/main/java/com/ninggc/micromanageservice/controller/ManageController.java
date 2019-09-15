package com.ninggc.micromanageservice.controller;

import com.ninggc.micromanageservice.client.UserClient;
import com.ninggc.microuserservice.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManageController {
    @Autowired
    UserClient userClient;

    @GetMapping
    public List<UserEntity> app() {
        return userClient.getAll("");
    }
}
