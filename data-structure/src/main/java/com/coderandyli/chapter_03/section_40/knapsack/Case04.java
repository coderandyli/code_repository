package com.coderandyli.chapter_03.section_40.knapsack;

/**
 * 优化case03 - 减少空间复杂度
 * - 二维数组改为一位数组
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/19 下午7:37
 */
public class Case04 {
    /**
     * 结果：背包中物品最大重量
     */
    private int result = Integer.MIN_VALUE;
    /**
     * 物品重量
     */
    private int[] items = {2, 2, 4, 6, 3};
    /**
     * 物品个数
     */
    private int n = 5;
    /**
     * 背包承受的最大重量
     */
    private int w = 9;


    public int knapsack() {
        boolean[] states = new boolean[w + 1]; // 默认值false
        // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0] = true;
        if (items[0] <= w) {
            states[items[0]] = true;
        }

        // 动态规划
        for (int i = 1; i < n; ++i) {
            // 把第i个物品放入背包
            for (int j = w; j >= 0; --j) {
                if (items[i] + j <= w) {
                    if (states[j]) states[j + items[i]] = true;
                }
            }
        }

        for (boolean s : states) {
            System.out.println("states = " + s);
        }

        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Case04 case04 = new Case04();
        int maxValue = case04.knapsack();
        System.out.println("maxvalue = " + maxValue);
    }
}
