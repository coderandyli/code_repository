package com.coderandyli.algo.fourth_complexity;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-05-04
 */
@Slf4j
public class Example {

    public static void main(String args[]) {
        final int value = 5;
        int[] array = {0, 1, 2, 33, 4, 5};
        log.debug("数值{}, 所在的位置为：{}", value, case01(array, value));
    }

    /**
     * ------------ 最好/最坏 时间复杂度分析 ------------
     *
     * 在一个无序的数据中，查找 x 所在的位置
     *      int[] array = {0, 1, 2, 33, 4, 5};
     *
     *   case1 最好情况时间复杂度:
     *      variable: int x = 0;
     *      console: 数值0, 所在的位置为：0
     *      conclusion： 该情况是最好情况时间复杂度； 时间复杂度为O(1)
     *
     *   case2 最坏情况时间复杂度:
     *      variable: int x = 5;
     *      console: 数值5, 所在的位置为：5
     *      conclusion： 该情况是最坏情况时间复杂度； 时间复杂度为O(n)
     */
    private static int case01(int[] array, int x) {
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }


}
