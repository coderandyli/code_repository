package com.coderandyli.project.service.impl;

import com.coderandyli.project.service.RedisBitMapService;
import com.coderandyli.project.service.RedisService;
import com.coderandyli.project.service.RedisServiceExtend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by lizhen on 2019-08-04
 */
@Slf4j
@Service
public class RedisBitMapServiceImpl implements RedisBitMapService {
    private static final String SIGN_UID_YEAR_KEY = "sign:19911007:2019";

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisServiceExtend redisServiceExtend;


    @Override
    public Boolean signIn() {
        for (int i = 0; i < 10; i++) {
            redisService.setBit(SIGN_UID_YEAR_KEY, i, true);
        }
        return true;
    }


    @Override
    public String getSignIn() {
        byte[] bytes = redisServiceExtend.get(SIGN_UID_YEAR_KEY);
        String binary = binary(bytes, 2);
        log.info("byte = {}", binary);
        return binary;
    }

    public static String binary(byte[] bytes, int radix) {
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

}
