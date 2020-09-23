package com.laoyin.mybatis.service;


import com.laoyin.mybatis.model.User;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月11日 1:44 下午
 */
public interface UserService {

    void update(Long id, String address);

    Boolean create(User user);
}
