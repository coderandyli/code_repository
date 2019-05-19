package com.coderandyli.lamda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lizhen on 2019-05-19
 * <p>
 * Lamda Stream 的演示代码
 */
public class StreamDemo {

    /**
     * forEach : 迭代流中的每个数据
     * 输出10个随机数
     */
    @Test
    public void test01() {
        Random random = new Random();
        IntStream ints = random.ints();
        ints.limit(10).forEach(System.out::println);
    }

    /**
     * map: 映射每个元素到对应的结果。
     *
     * 输出元素对应的平方数
     * distinct() ：去重
     */
    @Test
    public void test02(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     *
     */
    public void test03(){

    }

}
