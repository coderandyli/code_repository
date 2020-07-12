package com.coderandyli.exercise.backtracking;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/7/12 下午5:16
 */
public class EightQueens {
    /**
     * 下标表示行；值表示列
     */
    int[] result = new int[8];

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }

    public void cal8queens(int row) {
        // 棋盘已经放置好，打印输出结果
        if (row == 8) {
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }


    /**
     * 判断是否符合
     *
     * @param row
     * @param column
     * @return
     */
    public boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            // 判断正上方线
            if (result[i] == column) return false;

            // 判断左上对角线
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }

            // 判断右上对角线
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
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
