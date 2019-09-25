package com.coderandyli.monitor_tuning.test;

/**
 * Created by lizhen on 2019-09-24
 * ====================  反编译生成字节码信息=====================
 *
 * javac Test1.java
 *
 * javap -v Main.class
 *
 *
 * ====================  字节码信息=====================
 *
 *
 * {
 *   public com.coderandyli.monitor_tuning.test.Test1();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 6: 0
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=0, locals=1, args_size=1
 *          0: return
 *       LineNumberTable:
 *         line 10: 0
 *
 *   public int test();
 *     descriptor: ()I
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=4, args_size=1 // 最大栈深度为2；局部变量个数为4
 *          0: bipush        13         // 常量13压入操作栈
 *          2: istore_1                 // 并保存到局部变量表的slot_1中（第1处）
 *          3: bipush        14         // 常量14压入操作栈
 *          5: istore_2                 // 并保存到局部变量表的slot_2中
 *          6: iload_1                  // 把局部变量表的slot_1元素(int x)压入操作栈
 *          7: iload_2                  // 把局部变量表的slot_2元素(int y)压入操作栈
 *          8: iadd                     // 把上方的两个数都取出来，在CPU里相加，并压回操作栈的站定
 *          9: istore_3                 // 把栈顶的结果存储到局部变量表的slot_3中
 *         10: iload_3
 *         11: ireturn                  // 返回栈顶元素值
 *       LineNumberTable:
 *         line 13: 0
 *         line 14: 3
 *         line 15: 6
 *         line 17: 10
 * }
 *
 * ====================  分析  =====================
 *
 *
 *
 *
 */
public class Test1 {

    public static void main(String args[]) {

    }

    public int test() {
        int x = 13;
        int y = 14;
        int z = x + y;
        return z;
    }

}
