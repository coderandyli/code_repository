package com.coderandyli.designpattern.chapter_08.section_67.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/13 上午11:24
 */
public interface Iterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
