package com.coderandyli.inner_class.c_anonymous_inner_class.case01;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-05-14
 *  不使用匿名内部类实现抽象方法
 */
@Slf4j
public class Test {

    @org.junit.Test
    public void test(){
        Person p = new Child();
        p.eat();
    }
}
