package com.laoyin.amqp.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月14日 3:36 下午
 */

@SpringBootApplication(scanBasePackages = "com.laoyin.amqp.client")
public class RabbitmqClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqClientApplication.class, args);
    }
}
