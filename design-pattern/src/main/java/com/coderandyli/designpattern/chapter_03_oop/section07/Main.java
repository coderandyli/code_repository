package com.coderandyli.designpattern.chapter_03_oop.section07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by lizhen on 2019-11-22
 */
public class Main {
    public static void main(String args[]) {

        List<String> objects = new ArrayList<>();

        // 获取一个不可修改的集合
        List<String> strings = Collections.unmodifiableList(objects);
    }
}
