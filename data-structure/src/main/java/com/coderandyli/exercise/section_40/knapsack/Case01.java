package com.coderandyli.exercise.section_40.knapsack;

/**
 * 回溯算法实现0-1背包问题
 * 穷举、递归
 * <p>
 * 分析
 * 1. 每个物品都有装入背包和不装入背包两种可能。
 * 2. 使用递归，分别对这两种情况计算
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/11 下午5:11
 */
public class Case01 {
    /**
     * 结果：背包中物品最大重量
     */
    private int result = Integer.MIN_VALUE;
    /**
     * 物品重量
     */
    private int[] weight = {2, 2, 4, 6, 3};
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
     * @param i  第i个物品
     * @param cw 当前背包重量
     */
    public void calResult(int i, int cw) {
        // 背包装满 或 物品装完
        if (i == n || cw == w) {
            if (result < cw) result = cw;
            return;
        }

        // 不装第 i 个物品
        calResult(i + 1, cw);

        // 装第 i 个物品
        if (cw + weight[i] <= w) {
            calResult(i + 1, cw + weight[i]);
        }
    }

    public static void main(String[] args) {
        Case01 case01 = new Case01();
        case01.calResult(0, 0);
        System.out.println(case01.result);
    }
}
