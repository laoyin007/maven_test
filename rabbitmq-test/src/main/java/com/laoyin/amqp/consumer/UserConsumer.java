package com.laoyin.amqp.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Executable;
import java.util.concurrent.TimeUnit;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年09月15日 6:32 下午
 */
@Component
@Slf4j
public class UserConsumer {

    @RabbitListener(queues = {"user_queue"},concurrency = "5-10")
    public void test(String message) throws Exception {
        log.info("received {}", message);
        TimeUnit.MILLISECONDS.sleep(500L);
//        System.out.println("received " + message);
    }
}
