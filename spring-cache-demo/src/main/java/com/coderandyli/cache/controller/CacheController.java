package com.coderandyli.cache.controller;

import com.coderandyli.cache.constant.CacheConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.transaction.TransactionAwareCacheDecorator;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/1 下午4:18
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Autowired
    private GuavaCacheManager guavaCacheManager;

    @Autowired
    private CacheManager cacheManager;

    /**
     * 存入 redis
     * @param id
     * @return
     */
    @CachePut(value = CacheConstant.REDIS_CACHE_A, key = "#id")
    @GetMapping("/redis/put")
    public String userRedis(@RequestParam("id") String id) {
        return "redis value";
    }

    /**
     * 存入 guava
     * @param id
     * @return
     */
    @CachePut(value = CacheConstant.GUAVA_CACHE_A, cacheManager = "guavaCacheManager", key = "#id")
    @GetMapping("/guava/put")
    public String guavaPut(@RequestParam("id") String id) {
        return "guava value";
    }

    @Cacheable(value = CacheConstant.GUAVA_CACHE_A, cacheManager = "guavaCacheManager", key = "#id")
    @GetMapping("/guava/get")
    public String guavaGet(@RequestParam("id") String id) {
        return "guava value1";
    }

    @GetMapping("/names")
    public void getCacheNames() {
        System.out.println("redis cache names : " + redisCacheManager.getCacheNames());
        System.out.println("guava cache names : " + guavaCacheManager.getCacheNames());
        System.out.println("cache names : " + cacheManager.getCacheNames());
    }

    @GetMapping("")
    public void getCache() {
        TransactionAwareCacheDecorator
        Cache cache = redisCacheManager.getCache(CacheConstant.REDIS_CACHE_A);
        System.out.println(cache.getName());
    }



}
