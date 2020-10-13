package com.laoyin.mybatis.service.impl;

import com.laoyin.mybatis.mapper.UserMapper;
import com.laoyin.mybatis.model.User;
import com.laoyin.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月11日 1:44 下午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Long id, String address) {
        User user = userMapper.findById(id);
//        try {
//            TimeUnit.SECONDS.sleep(5L);
//        } catch (InterruptedException e) {
//        }
        user.setAge(22);
        userMapper.update(user);
    }

    @Override
    public Boolean create(User user) {
//        return userMapper.insert(user) > 0;
        return null;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
