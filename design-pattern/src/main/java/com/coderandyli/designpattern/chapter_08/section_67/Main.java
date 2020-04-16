package com.coderandyli.designpattern.chapter_08.section_67;


import com.coderandyli.designpattern.chapter_08.section_67.case_01.ArrayList;
import com.coderandyli.designpattern.chapter_08.section_67.case_01.Iterator;
import com.coderandyli.designpattern.chapter_08.section_67.case_01.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/13 上午11:08
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(2);

        Iterator<Integer> iter1 = list.iterator();//snapshot: 3, 8, 2
        list.remove(new Integer(2));//list：3, 8
        Iterator<Integer> iter2 = list.iterator();//snapshot: 3, 8
        list.remove(new Integer(3));//list：8
        Iterator<Integer> iter3 = list.iterator();//snapshot: 3

        // 输出结果：3 8 2
        while (iter1.hasNext()) {
            System.out.println(iter1.currentItem());
            iter1.next();
        }
        System.out.println();

        // 输出结果：3 8
        while (iter2.hasNext()) {
            System.out.println(iter2.currentItem());
            iter2.next();
        }
        System.out.println();

        // 输出结果：8
        while (iter3.hasNext()) {
            System.out.println(iter3.currentItem());
            iter3.next();
        }
        System.out.println();
    }
}
