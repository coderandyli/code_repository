package com.coderandyli.lock.demo.ReentrantLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: ReentrantLock Condition JDK示例
 * @author: lizhenzhen
 * @date: 2021-04-29 15:27
 *
 *
 * https://www.cnblogs.com/hongdada/p/6150699.html
 **/
public class ReentranLockConditionDemo {

    public static void main(String[] args) {
        final BoundedBuffer boundedBuffer = new BoundedBuffer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run");
                for (int i = 0; i < 20; i++) {
                    try {
                        System.out.println("putting..");
                        boundedBuffer.put(Integer.valueOf(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Object val = boundedBuffer.take();
                        System.out.println(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        t1.start();
        t2.start();
    }

    /**
     * 基于ReentrackLcok Condition实现的【有界缓存区】 {@link java.util.concurrent.ArrayBlockingQueue} 就是基于此实现的
     * - BoundedBuffer 是一个定长100的集合，当集合中没有元素时，take方法需要等待，直到有元素时才返回元素
     * - 当其中的元素数达到最大值时，要等待直到元素被take之后才执行put的操作
     *
     *
     * @author yukaizhao
     */
    static class BoundedBuffer {
        final Lock lock = new ReentrantLock(); // 锁对象
        final Condition notFull = lock.newCondition(); // 写线程条件
        final Condition notEmpty = lock.newCondition(); // 读线程条件

        final Object[] items = new Object[100]; // 缓冲队列
        int putptr, /*写索引*/ takeptr, /*读索引*/ count; /*队列中存在的数据个数*/

        public void put(Object x) throws InterruptedException {
            System.out.println("put wait lock");
            lock.lock();
            System.out.println("put get lock");
            try {
                while (count == items.length) { // 队列满了
                    System.out.println("buffer full, please wait");
                    notFull.await(); // 阻塞写线程
                }

                items[putptr] = x; // 赋值
                if (++putptr == items.length) putptr = 0; // 如果写索引写到队列的最后一个位置了，那么置为0
                ++count; // 个数++
                notEmpty.signal(); // 唤醒读线程
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            System.out.println("take wait lock");
            lock.lock();
            System.out.println("take get lock");
            try {
                while (count == 0) { // 队列为空
                    System.out.println("no elements, please wait");
                    notEmpty.await(); // 阻塞读线程
                }
                Object x = items[takeptr]; //取值
                if (++takeptr == items.length) // 如果读索引到队列的最后位置
                    takeptr = 0; // 读索引设置为0
                --count; // 个数--
                notFull.signal(); // 唤醒写线程
                return x;
            } finally {
                lock.unlock();
            }
        }
    }
}

