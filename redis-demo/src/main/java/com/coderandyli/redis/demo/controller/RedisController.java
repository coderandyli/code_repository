package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by lizhen on 2019-07-01
 */
@CacheConfig(cacheNames = {"cacheName"}) // 全局指定的缓存名字
@RestController
@Api(tags = "redis测试")
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;


    @ApiOperation(value = "注解Cacheable测试", notes = "", position = 1)
    @Cacheable(key = "#key")
    @PostMapping("/cacheable-test/{key}")
    public String cacheableTest(@PathVariable String key) {
        System.out.println("into method 【cacheableTest】");
        return "hello";
    }

}
