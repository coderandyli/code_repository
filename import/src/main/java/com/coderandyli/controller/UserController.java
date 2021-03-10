package com.coderandyli.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.coderandyli.entity.User;
import com.coderandyli.service.UserService;
import com.coderandyli.utils.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 *
 * @author coderandyli
 * 2019-04-03 22:15:20
 */
@Slf4j
@Api(tags = "User Apis")
@RestController
@RequestMapping("/user")
public class UserController {
    private static final int count = 10000;


    @Autowired
    private UserService userService;

    @ApiOperation(value = "插入", notes = "", position = 1)
    @PostMapping("/batch-insert")
    public Boolean batchInsert() {
        long startTime = System.currentTimeMillis();

        int temp = 0;
        List<List<User>> userList = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ++temp;

            User user = new User();
            user.setId(SnowflakeIdWorker.generateId());
            user.setUserName("andy" + i);
            user.setName("李振振" + i);
            user.setGender(1);
            users.add(user);

            if (temp == 10000 || i == (count - 1)) {
                temp = 0;
                userList.add(users);
                users = new ArrayList<>();
            }
        }

        for (List<User> list : userList) {
            userService.insertBatchUsers(list);
        }

        long endTime = System.currentTimeMillis(); // 5s
        log.debug("执行时间：{}", (endTime - startTime) / 1000);
        return true;
    }

    @ApiOperation(value = "根据名userName查询", notes = "", position = 1)
    @GetMapping("/selectByUserName")
    public List<User> selectByUserName(@RequestParam("userName") String userName){
        List<User> users = userService.selectList(new EntityWrapper<User>().eq("user_name", userName));
        return users;
    }
}
