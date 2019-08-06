package com.coderandyli.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by lizhen on 2019-07-01
 */
@Service
public class RedisService {

    private static final String ORIGINALURL_KEY = "originalUrl";

    @Autowired
    private RedisTemplate redisTemplate;

    private DefaultRedisScript<Boolean> bloomAdd;

    private DefaultRedisScript<Boolean> bloomExists;

    @PostConstruct
    public void init() {
        bloomAdd = new DefaultRedisScript();
        bloomAdd.setResultType(Boolean.class);
        bloomAdd.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/bloomFilterAdd.lua")));

        bloomExists = new DefaultRedisScript();
        bloomExists.setResultType(Boolean.class);
        bloomExists.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/bloomFilterExist.lua")));
    }

    /**
     * =============================================================================
     * =========          String             =========
     * =============================================================================
     */

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }


    /**
     * 自增
     * @param key
     * @return
     */
    public Long increment(String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.increment(key);
    }

    /**
     * =============================================================================
     * =========          BitMap             =========
     * =============================================================================
     */

    /**
     * 设值
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public Boolean setBit(String key, long offset, boolean value){
        ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
        return operations.setBit(key, offset, value);
    }

    /**
     * 查看是否存在
     * @param key
     * @param offset
     * @return
     */
    public Boolean getBit(String key, long offset){
        ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
        return operations.getBit(key, offset);
    }

//    public void test(){
//        ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
//        operations.bitField()
//    }

    /**
     * =============================================================================
     * =========          HASH             =========
     * =============================================================================
     */

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public String hmGet(String key, String hashKey) {
        HashOperations<String, String, String> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    public Boolean hHasKey(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.hasKey(key, hashKey);
    }

    /**
     * =============================================================================
     * =========          list             =========
     * =============================================================================
     */

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }


    /**
     * =============================================================================
     * =========          zSet             =========
     * =============================================================================
     */

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * 有序集合成员数量
     *
     * @param key
     * @return
     */
    public Long zCard(String key) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.zCard(key);
    }

    /**
     * 获取有序集合中指定成员的索引（排名）
     *
     * @param key
     * @param value
     * @return
     */
    public Long rank(String key, Object... value) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rank(key, value);
    }

    public Long zRemove(String key, Object... value) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.remove(key, value);
    }

    /**
     * 根据score 低 -> 高
     *
     * @param key
     * @param var1
     * @param var2
     * @return
     */
    public Set<Object> range(String key, Long var1, Long var2) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.range(key, var1, var2);
    }

    /**
     * 根据score 高 -> 低
     *
     * @param key
     * @param var1
     * @param var2
     * @return
     */
    public Set<Object> reverseRange(String key, Long var1, Long var2) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.reverseRange(key, var1, var2);
    }


    public Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, Long var1, Long var2) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.reverseRangeWithScores(key, var1, var2);
    }

    /***
     * score增量
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Double incrementScore(String key, String value, double score) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.incrementScore(key, value, score);
    }

    /**
     * 获取score
     *
     * @param key
     * @param value
     * @return
     */
    public Double score(String key, String value) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.score(key, value);
    }

    /**
     * =============================================================================
     * =========          Bloom filter             =========
     * =============================================================================
     */
    /**
     * 添加
     * @param value
     * @return
     */
    public Boolean bloomFilterAdd(String value){
        List<Object> keys= new ArrayList<>();
        keys.add(ORIGINALURL_KEY);
        keys.add(value);
        Boolean result = (Boolean) redisTemplate.execute(bloomAdd,keys);
        return result;
    }

    /**
     * I
     * @param value
     * @return
     */
    public Boolean bloomFilterExists(String value){
        List<Object> keys= new ArrayList<>();
        keys.add(ORIGINALURL_KEY);
        keys.add(value+"");
        Boolean result = (Boolean) redisTemplate.execute(bloomExists,keys);
        return result;
    }

}