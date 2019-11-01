package com.coderandyli.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-10-31
 *
 * 泛型方法测试
 * 在方法上直接声明 <T>： 方法返回值前的<T>就是为了告诉编译器，当前的方法的泛型类型可以和类的泛型类型不一致。
 */
@Slf4j
public class GenericMethod {

    public static void main(String args[]) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        log.debug("整型数组元素为: {}", printArray(intArray)); // 传递一个整型数组
        log.debug("双精度型数组元素为：{} ",printArray(doubleArray)); // 传递一个双精度型数组
        log.debug("字符型数组元素为 : {}",printArray(charArray)); // 传递一个字符型数组
    }

    // 泛型方法 printArray
    public static <T> String printArray(T[] inputArray) {
        StringBuilder builder = new StringBuilder();

        // 输出数组元素
        for (T element : inputArray) {
            // System.out.printf("%s ", element);
            builder.append(element);
        }
        return builder.toString();
    }
}
