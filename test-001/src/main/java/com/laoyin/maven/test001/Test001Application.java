package com.laoyin.maven.test001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.laoyin"})
public class Test001Application {

    public static void main(String[] args) {
        SpringApplication.run(Test001Application.class, args);
    }

}
