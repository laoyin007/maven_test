package com.laoyin.log4j2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年09月22日 2:59 下午
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController  {

    private AtomicInteger i = new AtomicInteger(0);

    private ExecutorService executor = Executors.newFixedThreadPool(20);

    @GetMapping
    public String test() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            int finalI = i;
            executor.execute(() -> {
                    log.info("executors {}", finalI);
            });

        }
//        TimeUnit.MINUTES.sleep(1L);
//
//        for (int i = 0; i < 10000; i++) {
//            int finalI = i;
//            executor.execute(() -> {
//                log.info("executors {}", finalI);
//            });
//
//        }
        return "ttt";
    }
}
