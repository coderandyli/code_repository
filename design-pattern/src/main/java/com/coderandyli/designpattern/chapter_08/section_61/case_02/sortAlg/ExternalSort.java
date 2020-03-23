package com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg;

import com.coderandyli.designpattern.chapter_08.section_61.case_02.SortAlg;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 上午10:30
 */
@SortAlg
public class ExternalSort implements ISortAlg {
    @Override
    public void sort(String filePath) {
        System.out.println("ExternalSort");
    }
}
