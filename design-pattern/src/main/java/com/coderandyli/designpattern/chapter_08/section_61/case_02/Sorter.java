package com.coderandyli.designpattern.chapter_08.section_61.case_02;

import com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg.ISortAlg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 上午10:18
 */
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;
    private static final List<AlgRange> algRanges = new ArrayList<>(8);
    {
        algRanges.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
        algRanges.add(new AlgRange(6 * GB, 12 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algRanges.add(new AlgRange(12 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algRanges.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
    }

    public void sortFile(String filePath) {
        // Ignore logical judgment
        File file = new File(filePath);
        long fileSize = 100; //file.length();
        ISortAlg sortAlg = null;
        for (AlgRange algRange : algRanges) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.getSortAlg();
                break;
            }
        }
        sortAlg.sort(filePath);
    }

}

