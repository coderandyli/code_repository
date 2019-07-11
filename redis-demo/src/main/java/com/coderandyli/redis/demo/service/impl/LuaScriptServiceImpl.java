package com.coderandyli.redis.demo.service.impl;

import com.coderandyli.redis.demo.service.LuaScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-07-10
 */

@Service("luaScriptService")
public class LuaScriptServiceImpl implements LuaScriptService {
    @Autowired
    private RedisTemplate redisTemplate;

    private DefaultRedisScript<List> getRedisScript;

    @PostConstruct
    public void init() {
        getRedisScript = new DefaultRedisScript();
        getRedisScript.setResultType(List.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/getList.lua")));
    }

    @Override
    public List<String> redisAddScriptExec() {

        List<String> list = new ArrayList<>();
        list.add("names_key");
        //定义 keys,argv和result序列化方式
        //控制每60秒的访问频率为5次
//        Object result = redisTemplate.execute(getRedisScript, new StringRedisSerializer(), new StringRedisSerializer(), list, "60", "5");/**/

        return (List<String>) redisTemplate.execute(getRedisScript, new StringRedisSerializer(), new StringRedisSerializer(), list);
    }
}


