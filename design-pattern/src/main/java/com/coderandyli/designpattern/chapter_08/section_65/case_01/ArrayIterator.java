package com.coderandyli.designpattern.chapter_08.section_65.case_01;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/1 下午2:10
 */
public class ArrayIterator<E> implements Iterator<E> {
    /**
     * 游标，当前位置
     */
    private int cursor;
    /**
     * 集合
     */
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor < arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }
}
