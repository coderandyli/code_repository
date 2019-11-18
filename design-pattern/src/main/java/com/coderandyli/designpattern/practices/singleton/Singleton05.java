package com.coderandyli.designpattern.practices.singleton;

/**
 * Created by lizhen on 2019-11-18
 *
 *  Folder模式
 *
 *  是否Lazy初始化：是
 *  是否多线程安全：是
 */
public class Singleton05 {

    public static class SingletonHolder{
            private static final Singleton05 INSTANCE = new Singleton05();
    }

    /**
     * 私有化构造方法
     */
    private Singleton05(){
    }

    public static Singleton05 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
