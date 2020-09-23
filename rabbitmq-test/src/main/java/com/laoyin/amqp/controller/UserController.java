package com.laoyin.amqp.controller;

import com.laoyin.amqp.dto.TestReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年09月15日 6:30 下午
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class UserController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private Integer i = 0;

    @GetMapping
    public void test() {
//        for (int i=0; i< 1000;i++) {
//            rabbitTemplate.convertAndSend("user_exchange", "user", "xxxxxx");
//
//        }
//        while (true) {
//            rabbitTemplate.convertAndSend("user_exchange", "user", "xxxxxx");
//        }
        i++;
        log.info("=== {}", i);
    }

    @PostMapping("test1")
    public void test1(@RequestBody TestReq req) {
        log.info("req: {}, {}", req.getAa(), req.getBb());
    }
}
