package com.laoyin.mybatis.service.impl;

import com.laoyin.mybatis.model.User;
import com.laoyin.mybatis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年10月12日 1:55 下午
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void test1() {
        List<User> users = jdbcTemplate.query("select * from user", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setAge(rs.getInt(3));
            user.setEmail(rs.getString(4));
            return user;
        });
        users.forEach(System.out::println);
    }
}
