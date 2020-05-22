package com.coderandyli.inner_class.c_anonymous_inner_class.case02;

import com.coderandyli.inner_class.b_local_inner_class.People;

/**
 * Created by lizhen on 2019-05-14
 * 匿名内部类实现抽象方法
 */
public class Test {

    @org.junit.Test
    public void test() {

        //方式一：匿名内部类实现抽象方法以及方法调用
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("eat ......");
            }
        };
        p.eat();

        //方式二：匿名内部类实现抽象方法以及方法调用
        new Person() {
            @Override
            public void eat() {
                System.out.println(" eat ......");
            }
        }.eat();
    }
}
