package com.coderandyli.lock.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @description: 多线程死锁检测
 * @author: lizhenzhen
 * @date: 2021-04-29 13:24
 **/
public class DeadLockDemo {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public void doActionA() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread() + ": acquire lock1");
            try {
                // 线程阻塞，让其他线程拿到lock2
                Thread.sleep(10);
            } catch (Exception e) {
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread() + ": acquire lock2");
            }
        }
    }

    public void doActionB() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread() + ": acquire lock2");
            synchronized (lock1) {
                System.out.println(Thread.currentThread() + ": acquire lock1");
            }
        }
    }

    public static void main(String[] args) {

        // 监控线程，进行线程死锁检测
        Thread monitorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
                    long[] ids = tmx.findDeadlockedThreads();
                    if (ids != null) {
                        ThreadInfo[] tmxThreadInfo = tmx.getThreadInfo(ids, true, true);
                        System.out.println("The following threads are deadlocked:");
                        for (ThreadInfo ti : tmxThreadInfo) {
                            System.out.println(ti);
                        }
                        break;
                    }
                }
            }
        });
        monitorThread.start();
        DeadLockDemo demo = new DeadLockDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.doActionA();
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.doActionB();
            }
        }, "thread2");
        thread1.start();
        thread2.start();
    }
}
