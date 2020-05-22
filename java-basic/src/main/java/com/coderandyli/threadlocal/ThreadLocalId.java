package com.coderandyli.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 为了更直观的体会ThreadLocal的使用我们假设如下场景
 *   1.我们给每个线程生成一个ID。
 *   2.一旦设置，线程生命周期内不可变化。
 *   3.容器活动期间不可以生成重复的ID
 *
 * 我们创建一个ThreadLocal管理类：
 */

public class ThreadLocalId {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static void set(Integer integer) {
        threadId.set(integer);
    }

    public static int get() {
        return threadId.get();
    }

    public static void remove() {
        threadId.remove();
    }

    private static void incrementSameThreadId() {
        try {

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + "_" + i + ",threadId: " + threadId.get());
            }
        }finally {
            threadId.remove();
        }
    }

    public static void main(String[] args) {
        incrementSameThreadId();
        new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSameThreadId();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSameThreadId();
            }
        }).start();
    }

}
