package com.coderandyli.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhen on 2019-07-24
 * Synchronized demo
 *
 * synchronized 属于悲观锁
 */
@Slf4j
public class SynchronizedExample01 {

    // 修饰一个类
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {}-{}", j, i);
            }
        }
    }

    // 修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    // 修饰一个类
    public static void test3(int j) {
        synchronized (SynchronizedExample01.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }


    /**
     * 修饰一个静态方法
     *
     * synchronized修饰的静态方法，是原子性操作，同一时间下都是只有一个线程执行
     * @param j
     */
    public static synchronized void test4(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String args[]) {
        SynchronizedExample01 example1 = new SynchronizedExample01();
        SynchronizedExample01 example2 = new SynchronizedExample01();

        // main1(example1);
        // main2(example1, example2);
        main3(example1, example2);

    }

    /**
     * 模拟一个对象的两个进程同时调用被synchronized修饰 一段代码 或 方法
     *
     * @param example1
     */
    public  void main1(SynchronizedExample01 example1) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            // example1.test1(1);
            example1.test2(1);
        });
        executorService.execute(() -> {
            // example1.test1(2);
            example1.test2(2);
        });
    }

    /**
     * 模拟不同对象调用被synchronized修饰 一段代码 或 方法
     * @param example1
     * @param example2
     */
    public static void main2(SynchronizedExample01 example1, SynchronizedExample01 example2) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            // example1.test1(1);
            example1.test2(1);
        });
        executorService.execute(() -> {
            // example2.test1(2);
            example2.test2(2);
        });
    }

    /**
     * 模拟不同对象调用被synchronized修饰 一段代码 或 方法
     * @param example1
     * @param example2
     */
    public static void main3(SynchronizedExample01 example1, SynchronizedExample01 example2) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            // example1.test1(1);
            example1.test3(1);
        });
        executorService.execute(() -> {
            // example2.test1(2);
            example2.test3(2);
        });
    }

}
