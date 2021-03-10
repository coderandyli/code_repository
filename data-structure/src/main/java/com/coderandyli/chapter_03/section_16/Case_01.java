package com.coderandyli.chapter_03.section_16;

/**
 * 二分查找变体
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/21 上午9:37
 */
public class Case_01 {

    private int[] items = {8, 11, 19, 23, 27, 33, 45, 45, 45, 55, 67, 98, 100};

    private int n = 13;

    /**
     * 二分查找变体一：查找指定值第一个出现的位置
     *
     * @param value
     * @return
     */
    public int bsearch01(int value) {
        int low = 0;
        int hight = n - 1;
        while (low < hight) {
            int mid = low + (hight - low) >> 1;
            if (items[mid] < value) {
                low = mid + 1;
            } else if (items[mid] > value) {
                hight = mid - 1;
            } else {
                if (mid == 0 || items[mid - 1] != value) {
                    return mid;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变体一：查找指定值最后一个出现的位置
     *
     * @param value
     * @return
     */
    public int bsearch02(int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (items[mid] < value) {
                low = mid + 1;
            } else if (items[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (items[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Case_01 case_01 = new Case_01();
        System.out.println(case_01.bsearch02(45));
    }

}
