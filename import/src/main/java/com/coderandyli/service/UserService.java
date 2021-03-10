package com.coderandyli.service;

import com.baomidou.mybatisplus.service.IService;
import com.coderandyli.entity.User;

import java.util.List;

/**
 * 用户表
 *
 * @author coderandyli
 * 2019-04-03 22:15:20
 */
public interface UserService extends IService<User> {

    boolean insertBatchUsers(List<User> users);
}

