package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by lizhen on 2019-07-02
 *
 * Redis Sorted Set 使用
 *
 * 假设猎聘网有 10 万名猎头，每个猎头都可以通过做任务（比如发布职位）来积累积分，
 * 然后通过积分来下载简历。假设你是猎聘网的一名工程师，如何在内存中存储这 10 万个猎头 ID
 * 和积分信息，让它能够支持这样几个操作
 *     1、根据猎头的 ID 快速查找、删除、更新这个猎头的积分信息
 *     2、查找积分在某个区间的猎头 ID 列表
 *     3、查找按照积分从小到大排名在第 x 位到第 y 位之间的猎头ID 列表 (未实现)
 */
@RestController
@Api(tags = "redis sorted set(redis 有序集合)")
@RequestMapping("/redis/sortedSet")
public class RedisSortedSetsController {

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "有序集合添加 / 修改", notes = "", position = 1)
    @PostMapping("/zAdd/{key}/{value}/{scoure}")
    public void zAdd(@PathVariable String key,
                     @PathVariable String value,
                     @PathVariable double scoure) {
        redisService.zAdd(key, value, scoure);
    }

    @ApiOperation(value = "根据范围查询有序结合", notes = "", position = 1)
    @PostMapping("/rangeByScore/{key}/{scoure1}/{scoure2}")
    public Set<Object> rangeByScore(
            @PathVariable String key,
            @PathVariable double scoure1,
            @PathVariable double scoure2) {

        return redisService.rangeByScore(key, scoure1, scoure2);
    }

    @ApiOperation(value = "获取集合成员数", notes = "", position = 1)
    @PostMapping("/zCard/{key}")
    public Long selectSetsCount(@PathVariable String key) {
        return redisService.zCard(key);
    }

    @ApiOperation(value = "获取有序集合中指定成员的索引 （即 score）", notes = "", position = 1)
    @PostMapping("/rank/{key}/{value}")
    public Long rank(@PathVariable String key,
                     @PathVariable String value) {
        return redisService.rank(key, value);
    }

    @ApiOperation(value = "有序集合-删除", notes = "", position = 1)
    @PostMapping("/zRemove/{key}/{value}")
    public Long zRemove(@PathVariable String key,
                        @PathVariable String value) {
        return redisService.zRemove(key, value);
    }

}
