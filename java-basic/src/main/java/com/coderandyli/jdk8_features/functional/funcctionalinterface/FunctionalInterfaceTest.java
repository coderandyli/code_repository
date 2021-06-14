package com.coderandyli.jdk8_features.functional.funcctionalinterface;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Date 2021/6/10 1:39 下午
 * @Created by lizhenzhen
 */
public class FunctionalInterfaceTest {

    /**
     * 函数式接口{@link Predicate}测试
     * - 谓词接口, {@link Predicate#test(Object)}接收T对象并返回boolean
     */
    @Test
    public void predicateTest() {
        Predicate<Integer> predicate = s -> s == 1;
        Assert.assertTrue(predicate.test(1));
        Assert.assertFalse(predicate.test(2));

        // 检验是否包含 1
        Assert.assertTrue(
                checkIfContain(integer -> integer == 1)
        );
    }
    private boolean checkIfContain(Predicate<Integer> input) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (Integer item : list) {
            if (input.test(item) == true) return true;
        }
        return false;
    }


    /**
     * 函数式接口{@link java.util.function.Function}测试
     * 抽象方法是 R apply(T t)，接收T对象，返回R对象 。
     */
    @Test
    public void functionTest() {
        Integer calculate = calculate(i -> i + 1, 5);
        System.out.println(calculate);

        Integer calculate2 = calculate(i -> i * 1, 5);
        System.out.println(calculate2);
    }
    private Integer calculate(Function<Integer, Integer> function, Integer number) {
        return function.apply(number);
    }

    /**
     * 函数接口 Supplier 的使用
     * {@link Supplier#get()} 不接收参数，返回一个值
     */
    @Test
    public void supplierTest() {
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
