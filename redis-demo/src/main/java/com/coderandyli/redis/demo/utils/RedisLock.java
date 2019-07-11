package com.coderandyli.redis.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by lizhen on 2019-07-10
 * <p>
 * 基于redis实现的分布式锁
 */
@Slf4j
@Component
public class RedisLock {

    private static final String LOCK_KEY_PREFIX = "distributed_lock::";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间 + 过期时间
     * @return
     */
    public boolean lock(String key, String value) {
        key = LOCK_KEY_PREFIX + key;

        if (redisTemplate.opsForValue().setIfAbsent(key, value)) { // 成功加锁
            return true;
        }

        String currentValue = (String) redisTemplate.opsForValue().get(key);
        // 如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            // 获取上一个锁的时间 (设置新值返回旧值)
            String oldValue = (String) redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unloack(String key, String value) {
        key = LOCK_KEY_PREFIX + key;
        try {
            String currentValue = (String) redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("【Redis分布式锁】解锁异常, {}", e);
        }
    }
}
