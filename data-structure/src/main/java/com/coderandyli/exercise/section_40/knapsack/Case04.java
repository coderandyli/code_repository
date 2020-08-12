package com.coderandyli.exercise.section_40.knapsack;

/**
 * 基于case03减少空间复杂度
 * 将status数组改成一维数组
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/11 下午5:11
 */
public class Case04 {
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
    private int w = 9;
    /**
     * 状态集合
     */
    private boolean[] states = new boolean[w + 1];

    public void calResult() {
        // 第0个物品特殊处理
        states[0] = true;
        if (weight[0] < w) {
            states[weight[0]] = true;
        }

        // 动态规划
        for (int i = 1; i < n; i++) {
            // 第 i 个物品装入背包
            for (int j = w; j > 0; j--) {
                if ((j + weight[i]) <= w) {
                    if (states[j]) states[j + weight[i]] = true;
                }
            }
        }

        // 打印最大值
        for (int i = w; i > 0; i--) {
            if (states[i]) {
                result = i;
                return;
            }
        }
    }

    public static void main(String[] args) {
        Case04 case01 = new Case04();
        case01.calResult();
        System.out.println(case01.result);
    }
}
