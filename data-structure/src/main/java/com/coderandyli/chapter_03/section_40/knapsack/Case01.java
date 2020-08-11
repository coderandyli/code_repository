package com.coderandyli.chapter_03.section_40.knapsack;

/**
 * 基于回溯算法实现0-1背包问题
 *  穷举、递归树
 *
 *  时间复杂度
 *      O(2^n) 是指数级的
 *
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/19 上午10:06
 */
public class Case01 {

    /**
     * 结果：背包中物品最大重量
     */
    private int result = Integer.MIN_VALUE;
    /**
     * 物品重量
     */
    private int[] weight = {2,2,4,6,3};
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
     * @param i 背包中第{i}物品
     * @param cw 当前背包重量
     */
    private void calResult(int i, int cw) {
        // 背包装满或者物品装完
        if (cw == w || i == n){
            if (cw > result) result = cw;
            return;
        }

        // 第{i}个物品不放入背包
        calResult(i+1, cw);
        if (cw + weight[i] <= w){
            // 第{i}个物品放入背包
            calResult(i+1, cw+weight[i]);
        }
    }

    public static void main(String[] args) {
        Case01 case01 = new Case01();
        case01.calResult(0, 0);

        System.out.println("result = " + case01.result);
    }

}
