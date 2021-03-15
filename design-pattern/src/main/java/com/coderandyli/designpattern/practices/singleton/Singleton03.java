package com.coderandyli.designpattern.practices.singleton;

/**
 * Created by lizhen on 2019-11-18
 * <p>
 * 饱汉模式，DCL（Double Checked Lock）
 * 是否Lazy初始化：是
 * 是否多线程安全：是
 *
 * 参考资料
 * - https://www.jianshu.com/p/d82cbb83f393?from=timeline
 * - http://ifeve.com/java-volatile关键字/#more-45241
 *
 *
 */
public class Singleton03 {

    /**
     * volatile
     *  1、保证可见性
     *  2、禁止指令重排序，有序性
     *  3、只保证单次读/写的原子性
     *  指令重排问题：
     *        高版本的 jdk（1.5以后） 已经在 JDK 内部实现中解决了这个问题（解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序, 所以说可以不加 volatile 关键字
     */
    private volatile static Singleton03 instance;

    /**
     * 私有化构造方法
     */
    private Singleton03() {
    }

    /**
     * 代码性能分析
     * - 只有第一次访问时，才会进入同步代码块，避免了 synchronized带来了性能损耗。
     */
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
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton03 instance = Singleton03.getInstance();
    }
}
