package com.coderandyli.designpattern.chapter_08.section_65.case_01;

import java.util.ArrayList;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/1 下午2:23
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("4444");

        Iterator<String> iterator = new ArrayIterator<>(list);
        while (iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
