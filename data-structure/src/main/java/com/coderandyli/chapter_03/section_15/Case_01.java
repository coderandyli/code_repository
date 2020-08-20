package com.coderandyli.chapter_03.section_15;

/**
 * 通过循环实现一个简单的二分查找
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/20 上午11:34
 */
public class Case_01 {

    private int[] items = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98, 100};

    private int n = 11;

    public int bsearch(int value) {
        int low = 0;
        int hight = n - 1;

        while (hight > low) {
            // int mid = (low + hight) / 2;  // 如果low、hight过大，两数之后可能会溢出
            // int mid = low + (hight - low)/2;
            int mid = low + (hight - low) >> 1;
            if (items[mid] == value) {
                return value;
            } else if (items[mid] < value) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Case_01 case01 = new Case_01();
        System.out.println(case01.bsearch(19));
    }
}
