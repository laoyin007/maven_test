package com.laoyin.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月11日 1:40 下午
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
