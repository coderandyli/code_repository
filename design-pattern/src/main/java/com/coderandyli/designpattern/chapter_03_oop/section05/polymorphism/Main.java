package com.coderandyli.designpattern.chapter_03_oop.section05.polymorphism;

/**
 * Created by lizhen on 2019-11-22
 */
public class Main {
    public static void main(String args[]) {
        printf(new Array());
        printf(new LinkedList());
    }

    /**
     * 基于接口的多态特性
     * @param iterator
     */
    public static void printf(Iterator iterator){
        iterator.hasNext();
    }
}
