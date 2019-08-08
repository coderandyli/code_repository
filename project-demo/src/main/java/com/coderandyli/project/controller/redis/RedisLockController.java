package com.coderandyli.project.controller.redis;

import com.coderandyli.project.utils.RedisLock;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-08-08
 */
@RestController
@RequestMapping("/redis-lock")
public class RedisLockController {

    @Autowired
    private RedisLock redisLock;

    @ApiOperation(value = "加锁", notes = "")
    @PostMapping("/lock")
    public boolean lock(){
        boolean lock = redisLock.lock("key", "value");
        return lock;
    }

    @ApiOperation(value = "解锁", notes = "")
    @PostMapping("/unlock")
    public boolean unlock(){
        boolean unlock = redisLock.unlock("key", "value");
        return unlock;
    }
}
