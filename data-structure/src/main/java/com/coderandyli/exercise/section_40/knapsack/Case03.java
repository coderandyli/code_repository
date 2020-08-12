package com.coderandyli.exercise.section_40.knapsack;

/**
 * 基于动态规划解决0-1背包问题
 * <p>
 * 分析
 * 1.
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/11 下午5:11
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

    public void calResult() {
        // 第0个物品特殊处理
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            // 第 i 个物品不装入背包
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }

            // 第 i 个物品装入背包
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j]) {
                    if (j + weight[i] < w) {
                        /**
                         * 重复子问题
                         *  如果对应的状态为true, 不再进行赋值操作
                         */
                        if (!states[i][j + weight[i]]) {
                            states[i][j + weight[i]] = true;
                        }
                    }
                }
            }
        }

        // 打印最大值
        for (int i = w; i > 0; i--) {
            if (states[n - 1][i]) {
                result = i;
                return;
            }
        }
    }

    public static void main(String[] args) {
        Case03 case01 = new Case03();
        case01.calResult();
        System.out.println(case01.result);
    }
}
