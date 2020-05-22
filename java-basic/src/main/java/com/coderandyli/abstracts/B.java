package com.coderandyli.abstracts;

public class B extends A {

    @Override
    public void test01() {
        System.out.println("Class B method test01 before");
        super.test01();
        System.out.println("Class B method test01 after");
    }

    @Override
    public void test02() {
        super.test02();
    }
}
