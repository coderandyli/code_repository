package com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg;

import com.coderandyli.designpattern.chapter_08.section_61.case_02.SortAlg;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 上午10:31
 */
@SortAlg
public class MapReduceSort implements ISortAlg{
    @Override
    public void sort(String filePath) {
        System.out.println("MapReduceSort");
    }
}
