package com.coderandyli.monitor_tuning.test;

/**
 * Created by lizhen on 2019-10-11
 *
 * 判断对象是否存活的算法，
 *  - 肯定不是引用计数算法，因为对象互相引用，无法释放
 *  - 使用的是可达性分析算法
 *
 *
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024*1024;
    /**
     *
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[_1MB];

    public static void main(String args[]) {
        testGC();
    }

    /**
     * VM args
     *  -Xloggc:/Users/lizhen/Desktop/gc.log -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     *
     * 运行结果
     *  对象被回收
     */
    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }
}
