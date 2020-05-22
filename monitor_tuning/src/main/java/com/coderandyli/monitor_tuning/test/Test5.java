package com.coderandyli.monitor_tuning.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-10-05
 * <p>
 * RunTimeConstantPool Test
 * 运行时常量池具有动态性，String.intern()可以在运行期间将新的常量加入到运行时常量池中
 */
public class Test5 {
    public static void main(String args[]) {

        test02();
    }

    /**
     * ================== jdk6 ==================
     * 运行结果
     * false
     * true
     * true
     * false
     * <p>
     * 结论
     * jdk6 intern()方法把首次遇到的字符串实例复制到（永久代的）运行时常量池中，所以
     * 1> str1 与 str1.intern() 不是一个实例引用
     * 2> str2 与 str3 是一个同一个实例引用（即str1.intern()的实例引用）
     * 3> str4 与 str5 分别创建不同的对象
     * <p>
     * ================== jdk7 ==================
     * 运行结果
     * true
     * true
     * true
     * false
     * 结论
     * jdk7之后，intern()方法不在复制首次遇到的字符串实例，而是记录其实例引用，所以
     * 1> str1 与 str1.intern() 是一个实例引用
     * 其他结论不变
     * <p>
     * ================== jdk8 ==================
     * <p>
     * 同jdk7
     */
    public static void test01() {

        String str1 = new StringBuffer("abc").append("def").toString(); // 堆中创建实例
        System.out.println(str1 == str1.intern());

        String str2 = "abcdef"; // 运行时常量池的str1.intern()的引用
        String str3 = "abcdef"; // 运行时常量池的str1.intern()的引用
        System.out.println(str2 == str1.intern());
        System.out.println(str2 == str3);

        String str4 = new String("abcdef"); // 创建新的实例，新的引用
        String str5 = new String("abcdef"); // 创建新的实例，新的引用
        System.out.println(str4 == str5);
    }

    /**
     * ================== jdk6 ==================
     * VM Args
     * -XX:PermSize=8M -XX:MaxPermSize=8M
     *
     * 运行结果
     *  java.lang.OutOfMemoryError: PermGen space
     *
     * 结论
     *  jdk6 intern()方法把首次遇到的字符串实例复制到（永久代的）运行时常量池中，所有在永久代10M的空间内，很快内存溢出；
     *
     *
     * ================== jdk7 ==================
     * VM Args
     *  -XX:PermSize=8M -XX:MaxPermSize=8M
     *
     * 运行结果
     *  运行正常
     *
     * 结论
     *  jdk7之后 intern()方法不在复制首次遇到的字符串实例，而是记录其实例引用，所以运行正常
     */
    public static void test02() {

        // 使用List 保持常量池的引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
