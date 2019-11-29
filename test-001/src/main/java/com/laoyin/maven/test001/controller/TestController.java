package com.laoyin.maven.test001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongyq
 * @date 2019-11-29 16:59
 * Description:
 */
@RestController
public class TestController {


    @GetMapping("/")
    String test() {
        return "Hello World!";
    }
}
