package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.annotation.RepeatSubmit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-07-10
 * 基于Redis分布式锁测试
 */
@Api("分布式锁测试")
@RestController
@RequestMapping("/distributedLock")
public class DistributedLockController {

    @RepeatSubmit
    @ApiOperation(value = "注解测试", notes = "", position = 1)
    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
