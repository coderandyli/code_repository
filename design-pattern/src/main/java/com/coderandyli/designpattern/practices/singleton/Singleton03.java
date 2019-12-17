package com.coderandyli.designpattern.practices.singleton;

/**
 * Created by lizhen on 2019-11-18
 * <p>
 * 饱汉模式，DCL
 * 是否Lazy初始化：是
 * 是否多线程安全：是
 */
public class Singleton03 {

    /**
     * volatile
     *  1、保证可见性
     *  2、进制指令重排序，有序性
     *  3、只保证单次读/写的原子性
     */
    private volatile static Singleton03 instance;

    /**
     * 私有化构造方法
     */
    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        // 实例不存在，进入
        if (instance == null) {
            // 同步代码块，保证线程安全
            synchronized (Singleton03.class) {
                //再次检查实例是否存在，如果不存在才真的创建实例
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
            instance = new Singleton03();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton03 instance = Singleton03.getInstance();
    }
}
