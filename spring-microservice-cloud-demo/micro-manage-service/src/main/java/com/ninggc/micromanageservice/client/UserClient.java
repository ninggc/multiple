package com.ninggc.micromanageservice.client;

import com.ninggc.microuserservice.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/get/{token}")
    List<UserEntity> getAll(@PathVariable String token);

    @PostMapping("/login")
    UserEntity login(UserEntity user);

}
