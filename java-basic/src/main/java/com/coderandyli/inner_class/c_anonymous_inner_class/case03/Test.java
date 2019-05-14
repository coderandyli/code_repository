package com.coderandyli.inner_class.c_anonymous_inner_class.case03;

/**
 * Created by lizhen on 2019-05-14
 * ******** 使用匿名类实现接口 ********
 */
public class Test {

    @org.junit.Test
    public void test() {
        // 匿名类实现
        Person p1 = new Person() {
            @Override
            public void eat() {
                System.out.println("eat......");
            }
        };
        p1.eat();

        // lamda实现 （推荐）
        Person p2 = (() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("eat......");
            }
        });
        p2.eat();
    }
}
