package com.coderandyli.jdk8_features.functional.funcctionalinterface;

/**
 * Created by lizhen on 2019-11-13
 */
 @FunctionalInterface
public interface CustomFuntionInterface {
    String fetchName();

    /**
     * 静态方法
     */
    static void staticMethod(){
        System.out.println("CustomFuntionInterface.staticMethod");
    }

    static void staticMethod2(){
        System.out.println("CustomFuntionInterface.staticMethod2");
    }

    /**
     * default修饰符 接口支持默认方法
     */
    default void defaultMethod(){
        System.out.println("CustomFuntionInterface.defaultMethod");
    }

    /**
     * default修饰符 接口支持默认方法
     */
    default void defaultMethod2(){
        System.out.println("CustomFuntionInterface.defaultMethod2");
    }

}
