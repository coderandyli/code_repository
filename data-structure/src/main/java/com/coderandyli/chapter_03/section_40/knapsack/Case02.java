package com.coderandyli.chapter_03.section_40.knapsack;

/**
 * 优化Case01 - 通过备忘录的方式，解决重复计算的问题
 *  穷举、递归树
 *
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/19 上午10:06
 */
public class Case02 {

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
     * 备忘录，默认为false 数组大小为int[n][w+1]
     */
    private boolean[][] mem = new boolean[n][w+1];

    /**
     * 计算结果
     *
     * @param i 背包中第{i}物品
     * @param cw 当前背包重量
     */
    public void calResult(int i, int cw) {
        // 背包装满或者物品装完
        if (cw == w || i == n){
            if (cw > result) result = cw;
            return;
        }

        // 重复状态
        if (mem[i][cw]) return;
        // 记录当前状态
        mem[i][cw] = true;

        // 第{i}个物品不放入背包
        calResult(i+1, cw);
        if (cw + weight[i] <= w){
            // 第{i}个物品放入背包
            calResult(i+1, cw+weight[i]);
        }
    }

    public static void main(String[] args) {
        Case02 case01 = new Case02();
        case01.calResult(0, 0);

        System.out.println("result = " + case01.result);
    }

}
