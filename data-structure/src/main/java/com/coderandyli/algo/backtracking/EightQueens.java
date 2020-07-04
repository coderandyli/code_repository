package com.coderandyli.algo.backtracking;

/**
 * 八皇后问题
 *      有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子
 * <p>
 * 解题思路
 *      通过回溯思想解决
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/3 下午4:52
 */
public class EightQueens {
    /**
     * 下标表示【行】，值表示【列】
     */
    int[] result = new int[8];

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }

    public void cal8queens(int row) {
        // 棋盘已经放置好，打印输出结果
        if (row == 8) {
            System.out.println("result[] = " + result);
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOK(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    /**
     * 判断row行，colunm列是否合适
     *
     * @param row    行
     * @param column 列
     * @return
     */
    private boolean isOK(int row, int column) {
        int leftup = column - 1, rightup = column + 1;

        // 逐行往上查询每一行
        for (int i = row - 1; i >= 0; i--) {
            // 第i行的column列是否有旗子
            if (result[i] == column) return false;

            // 考察左上对角线是否有旗子
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }

            // 考察右上对角线是否有旗子
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }

            --leftup; ++rightup;
        }

        return true;
    }

    private void printQueens(int[] result) {
        // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
