package com.coderandyli.exercise.section_40.knapsackPro;

/**
 * 基于贪心算法实现0-1背包问题升级版问题
 * <p>
 * 分析
 * - 物品有装入背包与不装入背包两个决策
 * - 记录当前背包重量(cw)，并通过递归穷举所有可能，并获取结果
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/12 上午10:53
 */
public class Case05 {
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

    public void calResult(int i, int cw, int cv) {
        // 遍历完所有物品或达到最大重量
        if (i == n || cw == w) {
            if (result < cv) result = cv;
            return;
        }

        // 第i个物品不装入背包
        calResult(i + 1, cw, cv);

        // 第i个物品装入背包
        if ((cw + items[i]) <= w) calResult(i + 1, cw + items[i],cv + value[i]);
    }

    public static void main(String[] args) {
        Case05 case05 = new Case05();
        case05.calResult(0, 0, 0);
        System.out.println(case05.result);
    }

}
