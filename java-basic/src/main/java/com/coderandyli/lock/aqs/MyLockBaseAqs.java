package com.coderandyli.lock.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/4/19 下午11:20
 * <p>
 * 基于AQS自定义锁
 */
public class MyLockBaseAqs {
    /**
     * 同步器
     */
    private Sync sync = new Sync();

    /**
     * Inner class
     */
    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                // Sets the thread that currently owns exclusive access.
                // 设置当前现成独占访问权限（当期线程获取锁）
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    /**
     * 加锁
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 解锁
     */
    public void unlock() {
        sync.release(1);
    }


    static int cnt = 0;
    public static void main(String[] args) {
        MyLockBaseAqs myLock = new MyLockBaseAqs();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 加锁
                myLock.lock();

                int n = 10000;
                while (n > 0) {
                    cnt++;
                    n--;
                }

                // 释放锁
                myLock.unlock();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            //等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cnt);
    }
}
