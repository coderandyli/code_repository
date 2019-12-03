package com.coderandyli.jvm.chapter08.section_03.b_dispatch;

import java.io.Serializable;

/**
 * Created by lizhen on 2019-11-29
 * <p>
 * 重载方法的匹配优先级
 *
 * 下面代码执行的优先级
 *      char -> int -> long - > Character -> Serializable -> Object -> char
 *
 * 以下代码的执行优先级也是方法重载的本质
 *
 */
public class b_OverLoad {

//    public static void sayHello(char arg) {
//        System.out.println("Hello char");
//    }

    public static void sayHello(int arg) {
        System.out.println("Hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello Character");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello Serializable");
    }

    public static void sayHello(Object arg) {
        System.out.println("Hello object");
    }

    public static void sayHello(char... arg) {
        System.out.println("Hello char...");
    }


    public static void main(String args[]) {
        sayHello('a');
    }
}
