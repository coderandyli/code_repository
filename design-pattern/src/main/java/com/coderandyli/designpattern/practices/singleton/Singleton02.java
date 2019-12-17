package com.coderandyli.designpattern.practices.singleton;

/**
 * Created by lizhen on 2019-11-18
 *
 * 饱汉模式，线程安全
 *  是否Lazy初始化：是
 *  是否多线程安全：是
 */
public class Singleton02 {
    private static Singleton02 instance;

    /**
     * 私有化构造方法
     */
    private Singleton02(){
    }

    public static synchronized Singleton02 getInstance(){
        if (instance == null){
            instance = new Singleton02();
        }
        return instance;
    }
}
