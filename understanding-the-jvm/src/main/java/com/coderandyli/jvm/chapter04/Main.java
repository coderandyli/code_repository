package com.coderandyli.jvm.chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2019-12-23
 * <p>
 * 通过JvisualVM观察
 */
public class Main {

    public static void main(String args[]) throws InterruptedException {
//        fillHeap(100);
//        createBusyThread();

        Object obj = new Object();
        createLcokThread(obj);

    }


    /**
     * OOM演示
     *
     * @param num
     * @throws InterruptedException
     */
    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(1000);
            list.add(new OOMObject());
        }
        System.gc();
    }

    /**
     * 死循环演示
     * <p>
     * 演示结果
     * 线程"testBusyThread" 始终处于RUNNABLE状态；
     * Runnable状态的线程会被分配运行时间，但readBytes方法检查到流没有更新时会立刻归还执行令牌，这种等待只消耗很小的CPU资源。
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ;
                }
            }
        }, "testBusyThread");
        thread.start();
    }

    /**
     * 线程锁等待演示
     *
     * 线程"testLockThread" 处于WAITING状态
     */
    public static void createLcokThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }



}
