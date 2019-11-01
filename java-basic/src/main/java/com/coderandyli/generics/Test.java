package com.coderandyli.generics;

/**
 * Created by lizhen on 2019-10-31
 */
public class Test {

    public static void main(String args[]) {
        GenericClass<String> genericClass = new GenericClass<String>("类泛型测试");
        System.out.println(genericClass.getData());
    }
}
