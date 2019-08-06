package com.coderandyli.project.test;

import com.coderandyli.project.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lizhen on 2019-08-06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisBloomFileterTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void test01(){
        Boolean aBoolean = redisService.bloomFilterAdd("http://www.baidu.com1");
        System.out.println("是否添加成功 " + aBoolean);
    }

    @Test
    public void test02(){
        Boolean aBoolean = redisService.bloomFilterExists("http://www.baidu.com1");
        System.out.println("是否存在 " + aBoolean);
    }
}
