package com.coderandyli.lock.demo;

import com.coderandyli.lock.aqs.MyLockBaseAqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentranLock Demo
 * @author: lizhenzhen
 * @date: 2021-04-26 11:56
 **/
public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();
    private int count;

    /**
     * 修饰方法
     */
//    public synchronized void add(int n) {
//        count = count + n;
//    }

    /**
     * 修饰代码块
     */
//    public synchronized void add(int n) {
//        synchronized (this) {
//            count = count + n;
//        }
//    }

    /**
     * ReentranLock的实现，lock()
     */
//    public void add(int n) {
//        lock.lock(); // 拿不到会一直等待，直到拿到锁
//        try {
//            count = count + n;
//        } finally {
//            lock.unlock();
//        }
//    }
    public void add(int n) throws InterruptedException {
//        if (lock.tryLock()) { //尝试获取，立刻返回，拿到返回true, 拿不到返回false （因此计算结果可能存在偏差）
        if (lock.tryLock(1, TimeUnit.SECONDS)){ // //指定时间内尝试获取，立刻返回，拿到返回true, 拿不到返回false （因此计算结果可能存在偏差）
            try {
                count = count + n;
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    reentrantLockDemo.add(1);
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(1000);

        System.out.println(reentrantLockDemo.count);
    }


}
