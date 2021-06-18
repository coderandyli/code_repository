package com.coderandyli.lock.atomic;

import lombok.extern.slf4j.Slf4j;
import sun.lwawt.macosx.CSystemTray;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Date 2021/6/16 5:06 下午
 * @Created by lizhenzhen
 */
@Slf4j
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.incrementAndGet();
        atomicInteger.incrementAndGet();
        log.info("atomicInteger = {}", atomicInteger);
    }
}
