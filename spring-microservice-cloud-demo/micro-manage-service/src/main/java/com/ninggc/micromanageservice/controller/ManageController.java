package com.ninggc.micromanageservice.controller;

import com.ninggc.micromanageservice.client.UserClient;
import com.ninggc.microuserservice.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManageController {
    @Autowired
    UserClient userClient;

    @GetMapping
    public List<UserEntity> app() {
        return userClient.getAll("app");
    }
}
