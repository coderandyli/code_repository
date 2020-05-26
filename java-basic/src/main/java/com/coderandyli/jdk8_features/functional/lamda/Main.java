package com.coderandyli.jdk8_features.functional.lamda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by lizhen on 2019-05-15
 *
 * 简单的lamda表达式演示
 */

public class Main {

    private String[] players = {
            "Rafael Nadal",
            "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer",
            "Roger Federer",
            "Andy Murray",
            "Tomas Berdych",
            "Juan Martin Del Potro",
            "Richard Gasquet",
            "John Isner"};

    /**
     * 使用lamda表达式，进行遍历
     */
    @Test
    public void test01(){
        List<String> playerList =  Arrays.asList(players);

        // 使用 lambda 表达式以及函数操作(functional operation)
        playerList.forEach((palyer) -> System.out.println(palyer + ";"));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        playerList.forEach(System.out::println);
    }

    /**
     * lamda 实现接口或抽象方法 （包inner_class有类似）
     *
     * Runnable 为例
     */
    @Test
    public void test02(){
        // 使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();

        // 使用 lambda expression
        new Thread(() -> System.out.println("Hello world !")).start();
    }


    /**
     * 使用Lambdas排序集合
     *
     *Comparator 排序详见 包comparator
     * @see com.coderandyli.comparator.Test
     *
     * 1、根据name 首字母排序
     */
    @Test
    public void test03(){

        // 1.1 使用匿名内部类根据 name 排序 players
        /*Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });*/

        // 1.2 使用lamda
        Arrays.sort(players, Comparator.naturalOrder());

        // 输出
        Arrays.asList(players).forEach(System.out::println);
    }

    @Test
    public void test04(){
        Stream<String> stream = Arrays.asList(players).stream();
    }



}
