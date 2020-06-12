package com.coderandyli.mybatis.mapper;

import com.coderandyli.mybatis.entity.User;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/12 下午1:20
 */
public interface UserMapper {
    User selectById(long id);
}
