package com.coderandyli.chapter_03.section_40.knapsack;

/**
 * 基于动态规划实现0-1背包问题
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/19 下午7:37
 */
public class Case03 {
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

    private boolean[][] states = new boolean[n][w + 1];

    /**
     * 0-1背包问题最优解 (背包中物品总重量的最大值)
     * <p>
     * 时间复杂度
     * O(n*w)
     */
    public int knapsack() {

        // 第一行数据特殊处理
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }

        // 动态规划状态转移（双重for循环）
        for (int i = 1; i < n; i++) {
            // 第i个物品不放入背包
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j] = true) states[i][j] = true;
            }

            // 第i个物品放入背包
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j]) {
                    if (j + weight[i] < w) {
                        // 重复子问题：如果对应的状态为true, 不再进行赋值操作
                        if (!states[i][j + weight[i]]) states[i][j + weight[i]] = true;
                    }
                }
            }
        }

        // 输出结果
        for (int i = w; i > 0; i--) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Case03 case03 = new Case03();
        int maxValue = case03.knapsack();
        System.out.println("maxvalue = " + maxValue);
    }
}
