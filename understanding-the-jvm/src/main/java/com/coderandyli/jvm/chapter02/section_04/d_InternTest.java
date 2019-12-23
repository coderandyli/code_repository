//package com.coderandyli.jvm.chapter02.section_04;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by lizhen on 2019-10-05
// * <p>
// * RunTimeConstantPool Test
// * Jdk1.6中
// * 字符串常量池在永久代中
// * 执行intern()方法时，若字符串常量池中不存在等值的字符串，JVM就会在字符串常量池中创建一个等值的字符串，然后返回该字符串的引用
// *
// * jdk1.7中
// * String.intern()
// * 字符串常量池移到了堆中
// * 执行intern操作时，如果常量池已经存在该字符串，则直接返回字符串引用，否则复制该字符串对象的**引用**到常量池中并返回
// *
// *
// * intern 使用场景测试
// *  case
// *      test_03 、 test_04
// *  执行结果
// *      noIntern: 77
// *      intern: 161
// *  结论
// *      适用于只有有限值，并且这些有限值会被重复利用的场景
// *
// *
// * Reference
// *      - https://blog.csdn.net/u011635492/article/details/81048150
// */
//public class d_InternTest {
//    public static void main(String args[]) {
//
////        test02();
////        System.out.println("noIntern: " + test_03());
////        System.out.println("intern: " + test_04());
//
//        System.out.println(test_05());
//        System.out.println(test_06());
//    }
//
//    /**
//     * ================== jdk6 ==================
//     * 运行结果
//     * false
//     * true
//     * true
//     * false
//     * <p>
//     * 结论
//     * jdk6 intern()方法把首次遇到的字符串实例复制到（永久代的）运行时常量池中，所以
//     * 1> str1 与 str1.intern() 不是一个实例引用
//     * 2> str2 与 str3 是一个同一个实例引用（即str1.intern()的实例引用）
//     * 3> str4 与 str5 分别创建不同的对象
//     * <p>
//     * ================== jdk7 ==================
//     * 运行结果
//     * true
//     * true
//     * true
//     * false
//     * 结论
//     * jdk7之后，intern()方法不在复制首次遇到的字符串实例，而是记录其实例引用，所以
//     * 1> str1 与 str1.intern() 是一个实例引用
//     * 其他结论不变
//     * <p>
//     * ================== jdk8 ==================
//     * <p>
//     * 同jdk7
//     */
//    public static void test01() {
//
//        String str1 = new StringBuffer("abc").append("def").toString(); // 堆中创建实例
//        System.out.println(str1 == str1.intern());
//
//        String str2 = "abcdef"; // 运行时常量池的str1.intern()的引用
//        String str3 = "abcdef"; // 运行时常量池的str1.intern()的引用
//        System.out.println(str2 == str1.intern());
//        System.out.println(str2 == str3);
//
//        String str4 = new String("abcdef"); // 创建新的实例，新的引用
//        String str5 = new String("abcdef"); // 创建新的实例，新的引用
//        System.out.println(str4 == str5);
//    }
//
//    /**
//     *
//     *
//     *
//     * ================== jdk6 ==================
//     * VM Args
//     * -XX:PermSize=8M -XX:MaxPermSize=8M
//     *
//     * 运行结果
//     *  java.lang.OutOfMemoryError: PermGen space
//     *
//     * 结论
//     *  jdk6 intern()方法把首次遇到的字符串实例复制到（永久代的/方法区的）运行时常量池中的字符串常量池中，所有在永久代10M的空间内，很快内存溢出；
//     *
//     * ================== jdk7 ==================
//     * VM Args
//     *  -XX:PermSize=8M -XX:MaxPermSize=8M
//     *
//     * 运行结果
//     *  运行正常
//     *
//     * 结论
//     *  jdk7之后 字符串常量池放在了堆中,intern()方法不在复制首次遇到的字符串实例，而是记录其实例引用，所以运行正常
//     */
//    public static void test02() {
//
//        // 使用List 保持字符串常量池的引用，避免Full GC回收常量池行为
//        List<String> list = new ArrayList<>();
//
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }
//    }
//
//    /**
//     * 未使用intern方法时，存储100万个String所需时间: 77ms
//     * @return
//     */
//    public static long test_03(){
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            int j = i % 100;
//            String str = String.valueOf(j);
//        }
//        return System.currentTimeMillis() - start;
//    }
//
//    /**
//     * 使用intern方法时，存储100万个String所需时间 ： 161ms
//     * @return
//     */
//    public static long test_04(){
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            int j = i % 100;
//            String str = String.valueOf(j).intern();
//        }
//        return System.currentTimeMillis() - start;
//    }
//
//    public static long test_05(){
//        long start = System.currentTimeMillis();
//        List<String> objects = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            objects.add(new String("123" + i));
//        }
//        return System.currentTimeMillis() - start;
//    }
//    public static long test_06(){
//        long start = System.currentTimeMillis();
//        List<String> objects = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            objects.add(new String("123"));
//        }
//        return System.currentTimeMillis() - start;
//    }
//
//}
