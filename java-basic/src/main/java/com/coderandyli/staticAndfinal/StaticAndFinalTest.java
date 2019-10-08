package com.coderandyli.staticAndfinal;

import java.util.Random;
/**
 * Created by lizhen on 2019-10-08
 *
 * static final 与 final的区别
 *
 * final：用来修饰类，变量，方法：
 *
 * final修饰的类不能有子类，也不能被继承。
 *
 * final修饰的变量是一个常量，不能重新赋值。
 *
 * final修饰的方法不能重写
 *
 * 现在就说明final修饰的常量① 与 static final 修饰的常量② 的区别。
 *
 * 例如：
 * ① final long CURRENT_TIME=system.currentMillis();
 *
 * ② static final long CURRENT_TIME=system.currentMillis();
 *
 * 不使用static修饰：
 *
 * 如果建立常量时直接赋一个固定值，那么这个常量的值是固定不变的，即多个对象中的值也是相同的。如果建立常量时是采用函数或对象，那么每次建立对象时给其常量的初始化值就有可能不同。所以，只使用final的Java常量定义并不是恒定的。
 *
 * 使用static修饰：
 *
 * 在创建对象之前就会为这个变量在内存中创建一个存储空间，以后创建对象如果需要用到这个静态变量，那么就会共享这一个变量的存储空间。
 */

public class StaticAndFinalTest {

    private static Random rand = new Random(47); //47作为随机种子，为的就是产生随机数。

    private final int a = rand.nextInt(20);

    private static final int B = rand.nextInt(20);

    public static void main(String[] args) {
        StaticAndFinalTest sf = new StaticAndFinalTest();
        System.out.println("sf : " + "a=" + sf.a);
        System.out.println("sf : " + "B=" + sf.B);
        System.out.println("------------------------------");
        StaticAndFinalTest sf1 = new StaticAndFinalTest();
        System.out.println("sf1 : " + "a=" + sf1.a);
        System.out.println("sf1 : " + "B=" + sf1.B);
    }
}