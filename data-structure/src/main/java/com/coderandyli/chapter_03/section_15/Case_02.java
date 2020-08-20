package com.coderandyli.chapter_03.section_15;

/**
 * 通过递归实现一个简单的二分查找
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/20 下午1:25
 */
public class Case_02 {

    private int[] items = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98, 100};

    private int n = 11;

    public int bsearch(int low, int hight, int value) {
        if (hight < low) return -1;

        int mid = low + (hight - low) >> 1 ;
        if (items[mid] == value){
            return value;
        }else if (items[mid] < value){
            low = mid + 1;
        }else {
            hight = mid -1;
        }
        return bsearch(low, hight, value);
    }

    public static void main(String[] args) {
        Case_02 case02 = new Case_02();
        System.out.println(case02.bsearch(0, case02.n - 1, 19));
    }
    
}
