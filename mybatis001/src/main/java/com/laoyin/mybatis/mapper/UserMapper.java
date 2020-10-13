package com.laoyin.mybatis.mapper;

import com.laoyin.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月11日 1:40 下午
 */
@Mapper
public interface UserMapper {

    User findById(Long id);

    int update(User user);

    List<User> findAll();
}
