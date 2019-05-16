package com.coderandyli.lamda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by lizhen on 2019-05-15
 */

public class Main {

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
     * 使用Lambdas排序集合
     * 1、根据name 首字母排序
     */
    @Test
    public void test03(){

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // 1.2 使用lamda
        Arrays.sort(players, (s1, s2) -> s1.compareTo(s2));

        // 输出
        Arrays.asList(players).forEach(System.out::println);
    }

    /**
     * 2、根据surname 首字母排序
     */
    @Test
    public void test04(){
        // 2.1 使用匿名类根据surname 排序
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
//            }
//        });

        // 2.2 使用lamda实现根据surname 排序
        Comparator<String> sortBySurname = (String s1, String s2) ->
                ( s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) ) );
        Arrays.sort(players, sortBySurname);

        // 输出
        Arrays.asList(players).forEach(System.out::println);
    }

    /**
     * 3、根据name 长度排序
     */
    @Test
    public void test05(){

        // 通过匿名类实现
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1.length() - o2.length());
//            }
//        });

        // 通过lamda实现
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

        // 输出
        Arrays.asList(players).forEach(System.out::println);
    }

    /**
     * 4、根据最后一个字母排序
     */
    @Test
    public void test06(){
        // 通过匿名类实现
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1.charAt(o1.length() - 1) - o2.charAt(o2.length() - 1));
//            }
//        });

        // 通过lamda实现
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));

        // 输出
        Arrays.asList(players).forEach(System.out::println);
    }


}
