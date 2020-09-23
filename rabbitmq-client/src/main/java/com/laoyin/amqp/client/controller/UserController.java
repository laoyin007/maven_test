package com.laoyin.amqp.client.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年09月15日 6:30 下午
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping
    public void test() {
        for (int i=0; i< 1000;i++) {
            rabbitTemplate.convertAndSend("user_exchange", "user", "xxxxxx");

        }
//        while (true) {
//            rabbitTemplate.convertAndSend("user_exchange", "user", "xxxxxx");
//        }
    }
}
