package com.coderandyli.designpattern.practices.singleton;

/**
 * Created by lizhen on 2019-11-18
 *
 * 饱汉模式，线程不安全
 *  是否Lazy初始化：是
 *  是否多线程安全：否
 */
public class Singleton01 {
    private static Singleton01 instance;

    /**
     * 私有化构造方法
     */
    public Singleton01(){
        System.out.println("Singleton01");
    }

    public static Singleton01 getInstance(){
        if (instance == null){
            instance = new Singleton01();
        }
        return instance;
    }
}
