package com.laoyin.mybatis.controller;

import com.laoyin.mybatis.model.User;
import com.laoyin.mybatis.service.UserService;
import io.growing.sdk.java.GrowingAPI;
import io.growing.sdk.java.dto.GIOEventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月11日 1:45 下午
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    public final static ExecutorService exeutor = Executors.newFixedThreadPool(9);

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }


    @PatchMapping
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable(value = "id") Long id) {
//        for (int i = 0; i < 1000; i++) {
//            final int j = i;
//            exeutor.execute(() -> userService.update(id, "xx" + j));
//        }
        userService.update(id, "xx");
    }
}
