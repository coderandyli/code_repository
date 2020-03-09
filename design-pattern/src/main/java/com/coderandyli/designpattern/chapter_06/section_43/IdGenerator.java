package com.coderandyli.designpattern.chapter_06.section_43;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程唯一的单例实现
 */
public class IdGenerator {
    private static final AtomicInteger id  = new AtomicInteger(0);

    private static final ThreadLocal<IdGenerator> instances = new ThreadLocal<IdGenerator>();

    private IdGenerator(){
    }

    public static IdGenerator getInstance() {

        IdGenerator idGenerator = instances.get();
        if (idGenerator == null){
            IdGenerator newIdGenerator = new IdGenerator();
            instances.set(newIdGenerator);
            return newIdGenerator;
        }
        return idGenerator;
    }

    public static void main(String[] args) {
        IdGenerator instance = getInstance();
        System.out.println(Thread.currentThread() + ":" +instance);
        System.out.println(Thread.currentThread() + ":" +instance);
        System.out.println("----------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                IdGenerator instance = getInstance();
                System.out.println(Thread.currentThread() + ":" +instance);
                System.out.println(Thread.currentThread() + ":" +instance);
                System.out.println("----------");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                IdGenerator instance = getInstance();
                System.out.println(Thread.currentThread() + ":" +instance);
                System.out.println(Thread.currentThread() + ":" +instance);
                System.out.println("----------");
            }
        }).start();

    }

}
