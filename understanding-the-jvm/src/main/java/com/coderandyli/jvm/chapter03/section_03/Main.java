package com.coderandyli.jvm.chapter03.section_03;

/**
 * Created by lizhen on 2019-12-20
 * <p>
 */
public class Main {

    private static final int _1MB = 1024 * 1024;

    /**
     *
     * 代码清单3-5
     *  测试代码分配情况
     *
     * VM args
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     *
     * Optional
     *  -XX:+UseConcMarkSweepGC       ParNew + CMS
     *
     * 内存分布
     * Young Generatiion 10M - 1M
     * - Eden： 8M
     * - Suvivor 1M
     * Old Generation 10M
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
    }

    /**
     * 代码清单3-6
     *  大对象直接进入 Old Generation
     *  测试 -XX:+UseConcMarkSweepGC参数 当对对象大于指定临界值，直接进入Old Generation（仅支持Serial、ParNew）
     *
     * VM args
     *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:PretenureSizeThreshold=3M -XX:+UseConcMarkSweepGC
     *
     */
    public static void testPretenureSizeThreshold(){
        byte[] allocation = new byte[8*_1MB];

    }

    /**
     *
     * 
     * 代码清单3-7
     *
     * 长期存活的对象直接进入老年代
     * -XX:MaxTenuringThreshold=1 设置年龄临界值
     *
     *
     * VM args
     *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
     *
     *  分别设置 -XX:MaxTenuringThreshold=1或15
     *
     *  测试结果
     *      没有达到预期
     *
     */
    // TODO: 2019-12-21 实验未达预期，可能与JDK版本、收集器有关
    @SuppressWarnings("unused")
    public static void testTenuringThreshold(){
        byte[] allocation1, allocation2;
        allocation1 = new byte[_1MB];
        allocation2 = new byte[3 * _1MB];
        allocation2 = null;
        allocation2 = new byte[3 * _1MB];
    }

    public static void main(String args[]) {
        testTenuringThreshold();
    }
}
