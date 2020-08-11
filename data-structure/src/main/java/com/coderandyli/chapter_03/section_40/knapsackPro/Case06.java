package com.coderandyli.chapter_03.section_40.knapsackPro;

/**
 * 动态规划实现0-1背包问题升级版
 * <p>
 * 思路
 * 使用二维数组(n,w)记录状态值， n表示第n个物品，w表示当前背包重量，其值value表示当前背包物品的总价值
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/21 下午5:26
 */
public class Case06 {
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


    public void knapsack() {
        // 记录状态值数据
        int[][] states = new int[n][w + 1];

        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                states[i][j] = -1;
            }
        }

        //第一行特殊处理
        states[0][0] = 0;
        if (weight[0] < w) {
            states[0][weight[0]] = value[0];
        }

        // TODO: 2020/7/22 动态规划，状态转移 
        for (int i = 1; i < n; i++) {
            // 第i个物品不放入背包
            for (int j = 0; j < w; j++) {
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
                // states[i][j] = states[i-1][j] + value[i];
            }
            // 第i个物品放入背包
            for (int j = 0; j < w - weight[i]; j++) {
                if (states[i-1][j] >= 0){

                }
            }

        }

        // 找出最大值
        for (int i = w; i > 0; i--) {
            if (states[n - 1][i] > maxV) maxV = states[n - 1][i];
        }
    }

    public static void main(String[] args) {
        Case06 case06 = new Case06();
        case06.knapsack();
        System.out.println("maxV = " + case06.maxV);
    }
}
