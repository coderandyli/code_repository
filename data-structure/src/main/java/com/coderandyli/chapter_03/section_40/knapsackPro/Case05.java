package com.coderandyli.chapter_03.section_40.knapsackPro;

import com.coderandyli.chapter_03.section_40.knapsack.Case01;

/**
 * 贪心算法实现0-1背包问题升级版
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/21 下午5:02
 */
public class Case05 {
    /**
     * 背包中物品最大总价
     */
    private int maxV = Integer.MIN_VALUE;
    /**
     * 物品重量
     */
    private int[] weight = {2, 2, 4, 6, 3};
    /**
     * 物品价值
     */
    private int[] value = {2, 4, 8, 9, 6};
    /**
     * 物品个数
     */
    private int n = 5;
    /**
     * 背包承受的最大重量
     */
    private int w = 16;

    /**
     * 计算结果
     *
     * @param i  背包中第{i}物品
     * @param cw 当前背包重量
     * @param cv 当前背包物品价格
     */
    private void calResult(int i, int cw, int cv) {
        // 背包装满或者物品装完
        if (cw == w || i == n) {
            if (cv > maxV) maxV = cv;
            return;
        }

        // 第{i}个物品不放入背包
        calResult(i + 1, cw, cv);
        if (cw + weight[i] <= w) {
            // 第{i}个物品放入背包
            calResult(i + 1, cw + weight[i], cv + value[i]);
        }
    }

    public static void main(String[] args) {
        Case05 case05 = new Case05();
        case05.calResult(0, 0, 0);
        System.out.println("result = " + case05.maxV);
    }

}
