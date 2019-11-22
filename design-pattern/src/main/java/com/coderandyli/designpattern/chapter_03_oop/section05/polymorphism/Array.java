package com.coderandyli.designpattern.chapter_03_oop.section05.polymorphism;

import java.util.HashMap;

/**
 * Created by lizhen on 2019-11-22
 */
public class Array implements Iterator {
    @Override
    public Boolean hasNext() {
        System.out.println("Array hasNext...");
        return null;
    }

    @Override
    public String next() {
        System.out.println("Array next...");
        return null;
    }

    @Override
    public String remove() {
        System.out.println("Array remove...");
        return null;
    }
}
