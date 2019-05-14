package com.coderandyli.inner_class.d_static_inner_class;

/**
 * Created by lizhen on 2019-05-14
 */
public class Outter {
    public Outter() {
    }

    static class Inner{
        public Inner() {
            System.out.println("创建静态内部类");
        }
    }
}
