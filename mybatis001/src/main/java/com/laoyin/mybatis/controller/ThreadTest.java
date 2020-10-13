package com.laoyin.mybatis.controller;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年10月12日 5:57 下午
 */
public class ThreadTest {
    private final static ThreadLocal<String> t = new ThreadLocal<>();
    private final static ThreadLocal<String> s = new ThreadLocal<>();

    public static void getT() {
        System.out.println(t.get());
    }

    public static void setT(String s) {
        t.set(s);
    }

    public static void getS() {
        System.out.println(s.get());
    }

    public static void setS(String str) {
        s.set(str);
    }
}
