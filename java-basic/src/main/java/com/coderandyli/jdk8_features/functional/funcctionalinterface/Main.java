package com.coderandyli.jdk8_features.functional.funcctionalinterface;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/25 下午4:32
 */
public class Main {

//    public static void main(String[] args) {
//        test_02();
//    }

    /**
     * 自定义函数接口的使用
     */
    @Test
    public void test_02() {
        String test = getIntroduce(() -> "Andy");
        System.out.println(test);
    }

    public String getIntroduce(CustomFuntionInterface customFuntionInterface) {
        return "my name is " + customFuntionInterface.fetchName();
    }


    /**
     * 函数接口 Supplier 的使用
     */
    @Test
    public void test_01() {
        int[] arr = {100, 20, 50, 30, 99, 101, -50};

        int maxValue = getMaxValue(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println("Array's max value is " + maxValue);
    }

    private int getMaxValue(Supplier<Integer> sup) {
        return sup.get();
    }
}
