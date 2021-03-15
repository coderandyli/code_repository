package com.coderandyli.designpattern.practices_02.singleton;

/**
 * DCL 方式实现单例
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/3/11 上午10:18
 */
public class Singleton01 {

    private volatile static Singleton01 instance;

    private Singleton01() {

    }

    public Singleton01 getInstance() {
        if (instance == null) {
            synchronized (Singleton01.class) {
                if (instance == null) {
                    instance = new Singleton01();
                }
            }
        }
        return instance;
    }
}
