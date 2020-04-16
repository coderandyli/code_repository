package com.coderandyli.designpattern.chapter_08.section_65.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/1 下午2:37
 */
public class ArrayList<E> implements List<E> {
    @Override
    public Iterator iterator() {
//        return new ArrayIterator(this);
        return null;
    }
}
