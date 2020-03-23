package com.coderandyli.designpattern.chapter_08.section_61.case_02;

import com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg.ISortAlg;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 上午10:41
 */
class AlgRange {
    private long start;
    private long end;
    private ISortAlg sortAlg;

    AlgRange(long start, long end, ISortAlg sortAlg) {
        this.start = start;
        this.end = end;
        this.sortAlg = sortAlg;
    }

    ISortAlg getSortAlg() {
        return sortAlg;
    }

    boolean inRange(long fileSize) {
        return start < fileSize  && fileSize < end;
    }
}
