package com.coderandyli.designpattern.chapter_08.section_61.case_02;

import com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg.ISortAlg;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 下午1:25
 */
public class Main {
    public static void main(String[] args) {
        ISortAlg quickSort = SortAlgFactory.getSortAlg("QuickSort");
        quickSort.sort("");
    }
}
