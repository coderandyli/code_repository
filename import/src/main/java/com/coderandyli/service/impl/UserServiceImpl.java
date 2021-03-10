package com.coderandyli.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.coderandyli.entity.User;
import com.coderandyli.mapper.UserMapper;
import com.coderandyli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertBatchUsers(List<User> users) {
        userMapper.insertBatchUsers(users);
        return true;
    }
}
