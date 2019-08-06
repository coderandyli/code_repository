package com.coderandyli.project.service.impl;

import com.coderandyli.project.service.RedisBitMapService;
import com.coderandyli.project.service.RedisService;
import com.coderandyli.project.service.RedisServiceExtend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.BitSet;

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
        log.info("得到的二进制  = {}", binary);

        // 转换成BitSet
        BitSet bitSet = fromByteArrayReverse(bytes);
        log.info("b1 = {}; b2 = {}; b3 = {}; ", bitSet.get(0), bitSet.get(1), bitSet.get(12));
        return binary;
    }

    public static String binary(byte[] bytes, int radix) {
        // 这里的1代表正数
        return new BigInteger(1, bytes).toString(radix);
    }


    /**
     * 解决bitSet java redis 字节顺序问题
     */
    private static BitSet fromByteArrayReverse(final byte[] bytes) {
        final BitSet bits = new BitSet();
        for (int i = 0; i < bytes.length * 8; i++) {
            if ((bytes[i / 8] & (1 << (7 - (i % 8)))) != 0) {
                bits.set(i);
            }
        }
        return bits;
    }

}
