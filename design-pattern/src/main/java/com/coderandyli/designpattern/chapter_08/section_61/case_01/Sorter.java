package com.coderandyli.designpattern.chapter_08.section_61.case_01;

import java.io.File;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 上午10:18
 */
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // Ignore logical judgment
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize < 6 * GB) {
            quickSort(filePath);
        } else if (fileSize < 12 * GB) {
            externalSort(filePath);
        } else if (fileSize < 100 * GB) {
            concurrentExternalSort(filePath);
        } else {
            mapreduceSort(filePath);
        }
    }

    /**
     * 快速排序
     * @param filePath
     */
    private void quickSort(String filePath) {
        System.out.println("quickSort");
    }

    /**
     * 外部排序
     * @param filePath
     */
    private void externalSort(String filePath) {
        System.out.println("externalSort");
    }

    /**
     * 多线程外部排序
     * @param filePath
     */
    private void concurrentExternalSort(String filePath) {
        System.out.println("concurrentExternalSort");
    }

    /**
     * 利用MapReduce多机排序
     * @param filePath
     */
    private void mapreduceSort(String filePath) {
        System.out.println("mapreduceSort");
    }
}

