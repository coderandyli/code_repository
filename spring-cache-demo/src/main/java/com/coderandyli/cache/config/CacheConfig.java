package com.coderandyli.cache.config;

import com.coderandyli.cache.constant.CacheConstant;
import org.springframework.context.annotation.Configuration;


import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author huxingnan
 * @date 2018/4/11 14:05
 */
@Configuration // 自动配置
@EnableCaching //启用Spring cache
public class CacheConfig {

    /**
     * 混合缓存管理
     *
     * @return cacheManager
     */
    @Bean("cacheManager")
    public CacheManager compositeCacheManager(@Autowired RedisConnectionFactory connectionFactory) {
        RedisCacheManager redisCacheManager = getRedisCacheManager(connectionFactory);
        GuavaCacheManager guavaCacheManager = getGuavaCacheManager();
        CompositeCacheManager cacheManager = new CompositeCacheManager(redisCacheManager, guavaCacheManager);
        cacheManager.setFallbackToNoOpCache(true);
        cacheManager.afterPropertiesSet();
        return cacheManager;
    }

    /**
     *  获取 redis管理 实例
     * @param connectionFactory
     * @return
     */
    @Primary // 默认CacheManager为 redisCacheManager
    @Bean("redisCacheManager")
    public RedisCacheManager getRedisCacheManager(RedisConnectionFactory connectionFactory) {
        Set<String> set = new LinkedHashSet<>();
        set.add(CacheConstant.REDIS_CACHE_A);
        set.add(CacheConstant.REDIS_CACHE_B);

        return RedisCacheManager.builder(connectionFactory)
                .initialCacheNames(set)
                .transactionAware()
                .build();
    }

    /**
     * 获取 guava缓存管理 实列
     *
     * @return
     */
    @Bean("guavaCacheManager")
    public GuavaCacheManager getGuavaCacheManager() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3600, TimeUnit.SECONDS).maximumSize(1000));
        ArrayList<String> guavaCacheNames = Lists.newArrayList();
        guavaCacheNames.add(CacheConstant.GUAVA_CACHE_A);
        guavaCacheManager.setCacheNames(guavaCacheNames);
        return guavaCacheManager;
    }

}
