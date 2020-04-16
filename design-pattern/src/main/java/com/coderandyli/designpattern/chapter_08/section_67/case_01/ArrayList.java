package com.coderandyli.designpattern.chapter_08.section_67.case_01;

import java.util.Arrays;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/13 上午11:23
 */
public class ArrayList<E> implements List<E> {

    private final static int DEFAULT_CAPACITY = 10;

    private final static Object[] EMPTY_ELEMENTDATA = {};

    private final static Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private Object[] elementData;

    public int size;

    private int modCount = 0;

    public ArrayList() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        size = 0;
    }

    public ArrayList(int initialCapacity) {
        elementData = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public void add(E obj) {
        modCount++;
        elementData = Arrays.copyOf(elementData, size + 1);
        elementData[size++] = obj;
    }

    @Override
    public boolean remove(E obj) {
        for (int index = 0; index < size; index++) {
            boolean sameElement = (obj == null)
                    ? elementData[index] == null
                    : obj.equals(elementData[index]);
            if (sameElement) {
                fastRemove(index);
                return true;
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMove = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMove);
        elementData[--size] = numMove; // clear to let GC do its work
    }

    @Override
    public Iterator<E> iterator() {
        return new SnapshotArrayIterator<>(this);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        // TODO: 2020/4/13 Ignore check logic
        if (index >= size){
            System.out.println("参数不合法");
            return null;
        }
        return (E) elementData[index];
    }
}
