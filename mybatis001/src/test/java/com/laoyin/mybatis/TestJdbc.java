package com.laoyin.mybatis;

import com.laoyin.mybatis.service.TestService;
import com.laoyin.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年10月12日 2:01 下午
 */
@SpringBootTest(classes = com.laoyin.mybatis.MybatisApplication.class)
@RunWith(SpringRunner.class)
public class TestJdbc {
    @Autowired
    private TestService testService;

    @Test
    public void test1() {
        testService.test1();
    }
}
