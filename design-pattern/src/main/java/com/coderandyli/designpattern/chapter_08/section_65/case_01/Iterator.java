package com.coderandyli.designpattern.chapter_08.section_65.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/1 下午2:08
 */
public interface Iterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
