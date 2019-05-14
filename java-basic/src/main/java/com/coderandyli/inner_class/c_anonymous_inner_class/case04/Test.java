package com.coderandyli.inner_class.c_anonymous_inner_class.case04;

/**
 * Created by lizhen on 2019-05-14
 */
public class Test {

    @org.junit.Test
    public void test01() {

        // 使用匿名内部类实现
        Thread t = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + " ");
                }
            }
        };
        t.start();

        // lamda实现 （推荐）
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " ");
            }
        }).start();
    }

    @org.junit.Test
    public void test02(){

        // 匿名类实现
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + " ");
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        // lamda实现 （推荐）
        Runnable r2 = (()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(i + " ");
            }
        });
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
