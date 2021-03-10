package com.coderandyli.controller;

import com.coderandyli.entity.User;
import com.coderandyli.mapper.UserMapper;
import com.coderandyli.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-06-12
 */
@Slf4j
@Api(tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "插入或更新", notes = "", position = 1)
    @PostMapping("/insertOrUpdate")
    public void insertOrUpdate(@RequestParam("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setUserName("我是插入数据");
        userService.insertOrUpdate(user);
    }

    @PostMapping("/isExsit")
    public Boolean isExsitUser(@RequestParam("id") Long id) {
        Integer value = userMapper.isExsitById(id);
        if (value == null)
            return false;
        return true;
    }

}
