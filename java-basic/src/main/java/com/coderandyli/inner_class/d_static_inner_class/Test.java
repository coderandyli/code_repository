package com.coderandyli.inner_class.d_static_inner_class;

/**
 * Created by lizhen on 2019-05-14
 *
 * 静态内部类是不需要依赖于外部类，静态内部类可以访问外部的static变量，
 * 不能使用外部类的非static变量(在没有外部类的对象的情况下可以创建静态内部类的对象，
 * 如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。)
 */
public class Test {

    @org.junit.Test
    public void test(){
        Outter.Inner inner = new Outter.Inner();
    }

}
