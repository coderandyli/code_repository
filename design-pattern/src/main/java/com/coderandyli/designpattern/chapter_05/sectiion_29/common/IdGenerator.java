package com.coderandyli.designpattern.chapter_05.sectiion_29.common;

public class IdGenerator {

    /**
     * 生成Id
     * @return
     */
    public static Long generateId () {
        return SnowflakeIdWorker.getInstance().generateId();
    }
}
