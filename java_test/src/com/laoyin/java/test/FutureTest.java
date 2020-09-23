package com.laoyin.java.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月12日 3:53 下午
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException {
       String str =  CompletableFuture.supplyAsync(()-> "hello")
                .thenApplyAsync(s -> s + " world").join();

        System.out.println(str);

        CompletableFuture.supplyAsync(() -> "hello").thenAccept(System.out::println);

       CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaaa==");
            return "aaaa";
        }).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("bbbb==");
            return "bbbb";
        }), (s1, s2) ->  s1 + s2).join();


        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ccc==");
            return "ccc";
        }).applyToEitherAsync(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ddd==");
            return "ddd";
        }), s -> s).join();
    }

}
