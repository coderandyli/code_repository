package com.coderandyli.functional;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by lizhen on 2019-11-12
 * <p>
 * 函数式编程
 */
public class Main {


    public static void main(String[] args) {
        // 创建数组
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
        System.out.println("数组中的最大值为: " + maxValue);

        Consumer c = () -> {
            System.out.println("112233");
        };
        c.accept();

        Consumer consumer = new Consumer() {
            @Override
            public void accept() {
                System.out.println("334455");
            }
        };
        consumer.accept();
    }

    public static int getMaxValue(Supplier<Integer> sup) {
        return sup.get();
    }
}
