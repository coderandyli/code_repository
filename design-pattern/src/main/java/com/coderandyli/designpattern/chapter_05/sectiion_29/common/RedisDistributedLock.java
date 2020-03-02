package com.coderandyli.designpattern.chapter_05.sectiion_29.common;

public class RedisDistributedLock {
    public static RedisDistributedLock getSingletonIntance() {
        return new RedisDistributedLock();
    }

    public boolean lockTransction(Long id) {

        return true;
    }

    public void unlockTransction(Long id) {

        return;
    }
}
