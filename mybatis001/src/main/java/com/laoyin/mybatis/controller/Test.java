package com.laoyin.mybatis.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年10月12日 5:52 下午
 */
public class Test {
    private static  ExecutorService executorService = Executors.newFixedThreadPool(9);


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int tmp = i;
            executorService.execute(() -> {
                ThreadTest.setT(String.valueOf(tmp));
                ThreadTest.setS(String.valueOf(tmp));
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ThreadTest.getT();
            });
        }
    }
}
