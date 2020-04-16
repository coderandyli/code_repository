package com.coderandyli.designpattern.chapter_08.section_67.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/13 上午11:24
 */
public class SnapshotArrayIterator<E> implements Iterator<E> {
    private int cursor;

    private ArrayList<E> arrayList;

    public SnapshotArrayIterator(ArrayList<E> arrayList) {
        cursor = 0;
        this.arrayList = new ArrayList<>(); //= arrayList;
        //this.arrayList.addAll(arrayList) // addAll() 方法未实现
    }

    @Override
    public boolean hasNext() {
        return cursor < arrayList.size ;
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        return arrayList.get(cursor);
    }
}
