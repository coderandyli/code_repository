package com.coderandyli.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class OptimisticLockAndPessimisticLockDemo {

    // -------------------------- 悲观锁调用方式 ------------------------------
    public synchronized void testMethod(){
        // 操作同步资源
    }

    private ReentrantLock lock = new ReentrantLock();
    public void modifyPublicResources(){
        lock.lock();
        // 操作同步资源
        lock.unlock();


    }

    // -------------------------- 乐观锁的调用方式 ------------------------------
    private AtomicInteger atomicInteger = new AtomicInteger(); // 保证多个线程使用同一个AtomicInteger
    // atomicInteger.incrementAndGet();  // 执行自增+1


}
