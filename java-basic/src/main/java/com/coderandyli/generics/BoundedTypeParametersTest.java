package com.coderandyli.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lizhen on 2019-10-31
 * <p>
 * 有界通配符(参数类型边界)
 *
 *
 */
public class BoundedTypeParametersTest {

    public static void main(String args[]) {
        BoundedTypeParametersTest parametersTest = new BoundedTypeParametersTest();

        Integer[] integers = new Integer[]{1, 2, 3};
        Double[] doubles = new Double[]{1d, 2d, 3d};
        String[] strings = new String[]{"1", "2", "3"};

        System.out.println("---------------- 上限通配符测试 ----------------");
        // 上限通配符测试
        parametersTest.upperBounded(Arrays.asList(integers)); // Integer
        System.out.println();
        parametersTest.upperBounded(Arrays.asList(doubles)); // Double
        System.out.println();
        // parametersTest.upperBounded(Arrays.asList(strings)); // String, 类型不支持

        System.out.println("---------------- 无界通配符测试 ----------------");
        // 无界通配符测试
        parametersTest.unbounded(Arrays.asList(integers)); // Integer
        System.out.println();
        parametersTest.unbounded(Arrays.asList(doubles)); // Double
        System.out.println();
        parametersTest.unbounded(Arrays.asList(strings)); // String


        System.out.println("---------------- 泛型类型测试 ----------------");
        parametersTest.genericType(Arrays.asList(integers)); // Integer
        System.out.println();
        parametersTest.genericType(Arrays.asList(doubles)); // Double
        System.out.println();
        parametersTest.genericType(Arrays.asList(strings)); // String

    }


    /**
     * 上限通配符
     *
     * @param numberList
     */
    public void upperBounded(List<? extends Number> numberList) {
        for (Number number : numberList) {
            System.out.println("number =" + number);
        }
    }

    /**
     * 无界通配符
     *
     * @param numberList
     */
    public void unbounded(List<?> numberList) {
        for (Object number : numberList) {
            System.out.println("number =" + number);
        }
    }

    public <T> void unbounded2(){
        List<T> list = new ArrayList<T>();
    }

    /**
     *
     * @param numberList
     * @param <T>
     */
    public <T> void genericType(List<T> numberList) {
        for (T number : numberList) {
            System.out.println("number =" + number);
        }
    }


}
