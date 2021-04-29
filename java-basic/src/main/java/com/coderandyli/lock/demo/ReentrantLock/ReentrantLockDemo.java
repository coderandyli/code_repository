package com.coderandyli.lock.demo.ReentrantLock;

import com.coderandyli.lock.aqs.MyLockBaseAqs;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentranLock Demo
 * @author: lizhenzhen
 * @date: 2021-04-26 11:56
 *
 * {@link ReentrantLock#lock()}  一直阻塞获锁，直至获取成功
 * {@link ReentrantLock#tryLock()} 尝试获锁，成功返回true; 失败返回false
 * {@link ReentrantLock#tryLock(long, TimeUnit)} 有时限的尝试获锁，成功返回true; 失败返回false
 * {@link ReentrantLock#lockInterruptibly()} 可中断的获锁(考虑死锁场景)
 **/
public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();
    private int count;

    /**
     * 【synchronized】修饰方法
     */
//    public synchronized void add(int n) {
//        count = count + n;
//    }

    /**
     * 【synchronized】修饰代码块
     */
//    public synchronized void add(int n) {
//        synchronized (this) {
//            count = count + n;
//        }
//    }

    /**
     * 【ReentranLock】lock()的实现
     */
//    public void add(int n) {
//        lock.lock(); // 拿不到会一直等待，直到拿到锁
//        try {
//            count = count + n;
//        } finally {
//            lock.unlock();
//        }
//    }

    /**
     * 【ReentranLock】tryLock()
     * 【ReentranLock】tryLock(1, TimeUnit.SECONDS)  --获锁有时限
     */
//    public void add(int n) throws InterruptedException {
////        if (lock.tryLock()) { //尝试获取，立刻返回，拿到返回true, 拿不到返回false （因此计算结果可能存在偏差）
//        if (lock.tryLock(1, TimeUnit.SECONDS)){ // 指定时间内尝试获取，立刻返回，拿到返回true, 拿不到返回false （因此计算结果可能存在偏差）---取消正在同步运行的操作，来防止不正常操作长时间占用造成的阻塞
//            try {
//                count = count + n;
//            } finally {
//                lock.unlock();
//            }
//        }
//    }

    public void add(int n) {
        try {
            lock.lockInterruptibly();
            try {
                count = count + n;
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("获锁失败，线程中断 ");
        }
    }

    /**
     * ---------------------------------- lock.lockInterruptibly（死锁场景演示） -----------------------------------------
     */

    public static class LockInterrupt extends Thread{
        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();
        private int lock;

        public LockInterrupt(int loc, String name) {
            super(name);
            this.lock = lock;
        }


        @Override
        public void run() {
            try {
                if (lock == 1){
//                    lock1.lockInterruptibly();
                    lock1.lock();
                    Thread.sleep(500);
//                    lock2.lockInterruptibly();
                    lock2.lock();
                }else {
//                    lock2.lockInterruptibly();
                    lock2.lock();
                    Thread.sleep(500);
//                    lock1.lockInterruptibly();
                    lock1.lock();
                }
            }catch (Exception e){

            }finally {
//                if (lock1.isHeldByCurrentThread()){
//                    lock1.unlock();
//                }
//                if (lock2.isHeldByCurrentThread()){
//                    lock2.unlock();
//                }
                System.out.println(Thread.currentThread().getId() + ":线程退出.");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
////                    try {
//                    reentrantLockDemo.add(1);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                }
//            }
//        };
//
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//
//        Thread.sleep(1000);
//
//        System.out.println(reentrantLockDemo.count);

        lockInterruptedTest();
    }
    
    public static void lockInterruptedTest(){
        LockInterrupt t1 = new LockInterrupt(1, "LockInterrupt1");
        LockInterrupt t2 = new LockInterrupt(2, "LockInterrupt2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
