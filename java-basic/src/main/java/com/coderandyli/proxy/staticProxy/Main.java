package com.coderandyli.proxy.staticProxy;

import com.coderandyli.proxy.Student;

/**
 * Created by lizhen on 2019-11-07
 *
 * 静态代理代理
 */
public class Main {

    public static void main(String args[]) {
        StudentProxy studentProxy = new StudentProxy(new Student());
        studentProxy.say("");
    }
}