package com.coderandyli.designpattern.chapter_08.section_67.case_01;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/13 下午1:31
 */
class ArrayListTest {

    @Test
    void add() {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        Assert.assertEquals(arrayList.size, 4);
    }

    @Test
    void remove() {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        boolean remove = arrayList.remove(4);
        Assert.assertEquals(remove, true);

        boolean remove1 = arrayList.remove(5);
        Assert.assertEquals(remove1, false);

        Assert.assertEquals(arrayList.size, 3);
    }

    @Test
    void iterator() {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }

    @Test
    void size() {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        Assert.assertEquals(arrayList.size, 4);
    }
}