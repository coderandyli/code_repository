package com.coderandyli.designpattern.chapter_03_oop.section05.polymorphism;

/**
 * Created by lizhen on 2019-11-22
 */
public class LinkedList implements Iterator {
    @Override
    public Boolean hasNext() {
        System.out.println("LinkedList hasNext...");
        return null;
    }

    @Override
    public String next() {
        System.out.println("LinkedList next...");
        return null;
    }

    @Override
    public String remove() {
        System.out.println("LinkedList remove...");
        return null;
    }
}
