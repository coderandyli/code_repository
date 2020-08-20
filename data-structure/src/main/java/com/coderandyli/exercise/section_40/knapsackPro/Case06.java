package com.coderandyli.exercise.section_40.knapsackPro;

/**
 * 基于动态规划实现0-1背包问题升级版问题
 * <p>
 * 分析
 * - 物品有装入背包和不装入背包两种决策
 * - 将每个物品的决策视为一个阶段，并记录当前阶段决策后的状态
 * - 通过当前阶段的状态，推导下一阶段的状态
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/12 上午10:53
 */
public class Case06 {
    /**
     * 结果：背包中物品最大价值
     */
    private int result = Integer.MIN_VALUE;
    /**
     * 物品重量集合
     */
    private int[] items = {2, 2, 4, 6, 3};
    /**
     * 物品价值集合
     */
    private int[] value = {3, 4, 8, 9, 6};
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
    private int[][] status = new int[n][w + 1];

    public void calResult() {
        // 第一个物品特殊处理
        status[0][0] = 0;
        if (items[0] <= w) {
            status[0][items[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {
            // 第 i 个物品不装入背包
            for (int j = 0; j < w; j++) {
                status[i][j] = status[i - 1][j];
            }

            // 第 i 个物品装入背包
            for (int j = 0; j < w; j++) {
                if (status[i - 1][j] >= 0) {
                    if (j + items[i] <= w) {
                        int v = status[i - 1][j] + value[i];
                        if (v > status[i][j + items[i]]) {
                            status[i][j + items[i]] = v;
                        }
                    }
                }
            }
        }

        for (int i = w; i > 0; i--) {
            if (result < status[n - 1][i]) result = status[n - 1][i];
        }
    }

    public static void main(String[] args) {
        Case06 case06 = new Case06();
        case06.calResult();
        System.out.println(case06.result);
    }

}
