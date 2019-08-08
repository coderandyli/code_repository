package com.coderandyli.project.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by lizhen on 2019-08-08
 * 基于redis lua的分布式锁
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
        unlockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/unlock.lua")));

        lockScript = new DefaultRedisScript();
        lockScript.setResultType(Boolean.class);
        lockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/lock.lua")));
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
        Boolean result = (Boolean) redisTemplate.execute(lockScript, Arrays.asList(key, value));
        return result;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public Boolean unlock(String key, String value) {
        key = LOCK_KEY_PREFIX + key;
        Boolean result = (Boolean) redisTemplate.execute(unlockScript, Arrays.asList(key, value));
        return result;
    }
}
