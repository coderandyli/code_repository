package com.coderandyli.designpattern.chapter_03_oop.section05.polymorphism;

/**
 * Created by lizhen on 2019-11-22
 */
public interface Iterator {
    Boolean hasNext();
    String next();
    String remove();
}
