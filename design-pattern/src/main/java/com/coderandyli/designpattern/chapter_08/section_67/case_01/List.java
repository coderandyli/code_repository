package com.coderandyli.designpattern.chapter_08.section_67.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/13 上午11:23
 */
public interface List<E> {
    /**
     * add obj
     * @param obj
     */
    void add(E obj);

    /**
     * remove obj
     * @param obj
     */
    boolean remove(E obj);

    /**
     * generate iterator
     * @return
     */
    Iterator<E> iterator();

    int size();

    /**
     * get specified element by index
     * @param index
     * @return
     */
    E get(int index);
}
