package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/cacheable-test")
    public String cacheableTest(@RequestParam String key) {
        System.out.println("into method 【cacheableTest】");
        return "hello";
    }
}
