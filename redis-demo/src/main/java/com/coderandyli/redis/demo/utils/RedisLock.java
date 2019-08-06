package com.coderandyli.redis.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;

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

    private DefaultRedisScript<Boolean> unlockScript;

    private DefaultRedisScript<Boolean> lockScript;


    @PostConstruct
    public void init() {
        unlockScript = new DefaultRedisScript();
        unlockScript.setResultType(Boolean.class);
        unlockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/unlock.lua")));

        lockScript = new DefaultRedisScript();
        lockScript.setResultType(Boolean.class);
        lockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/lock.lua")));
    }

    /**
     * 加锁
     *
     * @param key
     * @param value 当前时间 + 过期时间
     * @return
     */
    public boolean lock(String key, String value) {
        key = LOCK_KEY_PREFIX + key;
//        Boolean result = (Boolean) redisTemplate.execute(lockScript, Arrays.asList(key, value, String.valueOf(System.currentTimeMillis())));
//        return result;

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
    public Boolean unloack(String key, String value) {
//        try {
//            String currentValue = (String) redisTemplate.opsForValue().get(key);
//            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
//                redisTemplate.opsForValue().getOperations().delete(key);
//            }
//        } catch (Exception e) {
//            log.error("【Redis分布式锁】解锁异常, {}", e);
//        }
//        return true;

        key = LOCK_KEY_PREFIX + key;
        Boolean result = (Boolean) redisTemplate.execute(unlockScript, Arrays.asList(key, value));
        return result;
    }
}
