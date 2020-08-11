package com.coderandyli.chapter_03.section_42;

/**
 * 使用回溯算法获取莱文斯坦距离
 * 穷举、递归
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/30 下午7:46
 */
public class Case01 {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6; // a 的长度
    private int m = 6; // b 的长度
    private int minDist = Integer.MAX_VALUE; // 最小距离

    private void lwstBT(int i, int j, int edist) {
        // 是否遍历完成 i == n || j == m
        if (i == n || j == m) {
            if (i < n) edist = edist + (n - i);
            if (j < m) edist = edist + (m - j);
            // 获取最小值
            if (minDist > edist) minDist = edist;
            return;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1, j + 1, edist);
        } else {
            // 删除a[i] 或者b[j]前增加一个数
            lwstBT(i + 1, j, edist + 1);

            // 删除b[i] 或者a[j]前增加一个数
            lwstBT(i, j + 1, edist + 1);

            // 将a[i] 和 b[i] 替换成相同的值
            lwstBT(i + 1, j + 1, edist + 1);
        }
    }

    public static void main(String[] args) {
        Case01 case01 = new Case01();
        case01.lwstBT(0, 0, 0);
        System.out.println(case01.minDist);
    }
}
