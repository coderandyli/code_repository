package com.coderandyli.proxy.dynamicProxy;

import com.coderandyli.proxy.Behavior;
import com.coderandyli.proxy.Student;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.lang.reflect.Proxy;
import java.util.Hashtable;

/**
 * Created by lizhen on 2019-11-08
 */
public class Main {

    public static void main(String args[]) {
        //Proxy.getProxyClass()

        ProxyHandler proxy = new ProxyHandler();

        // 获取代理对象
        Behavior behavior = (Behavior)proxy.bind(new Student());
        behavior.eat();

        String s = System.lineSeparator();
        System.out.println("line separator : " + s + "end");
    }
}
