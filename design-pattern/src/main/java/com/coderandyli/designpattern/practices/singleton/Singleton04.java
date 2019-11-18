package com.coderandyli.designpattern.practices.singleton;

/**
 * Created by lizhen on 2019-11-18
 *
 * 饿汉式
 *  是否Lazy初始化：否
 *  是否多线程安全：是
 */
public class Singleton04 {
    private static Singleton04 instance = new Singleton04();

    /**
     * 私有化构造方法
     */
    private Singleton04(){
    }

    public static Singleton04 getInstance(){
        return instance;
    }
}
