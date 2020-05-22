package com.coderandyli.monitor_tuning.test;

/**
 * Created by lizhen on 2019-09-24
 *
 *
 *
 *
 * ====================  反编译生成字节码信息=====================
 *
 * javac Test2.java
 * javap -v Test2.class
 *
 * ====================  字节码信息 （部分代码忽略）=====================
 *
 *   public void test1();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: iconst_0                          // 将常量压入操作栈           0
 *          1: istore_1                          // 保存到局部变量表slot_1中   0
 *          2: iload_1                           // 将slot_1压入操作栈        0
 *          3: iinc          1, 1                // 在局部变量表（抽屉）中执行inc指令   1
 *          6: istore_2                          // 栈顶元素保存到局部变量表slot_2     0
 *          7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         10: iload_2                           // 将slot_2元素压入操作栈
 *         11: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *         14: return
 *       LineNumberTable:
 *         line 21: 0
 *         line 22: 2
 *         line 23: 7
 *         line 24: 14
 *
 *   public void test2();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=3, args_size=1
 *          0: iconst_0                  // 压入操作栈   0
 *          1: istore_1                  // 保存在局部变量表slot_1中   0
 *          2: iinc          1, 1        // 在局部变量表中（抽屉）中执行inc指令 1
 *          5: iload_1                   // 将slot_1元素压入操作栈            1
 *          6: istore_2                  // 保存到局部变量表                  1
 *          7: return                    // 返回  1
 *       LineNumberTable:
 *         line 27: 0
 *         line 28: 2
 *         line 29: 7
 *
 * ==================== 分析 =====================
 *
 *        i++             |           ++I
 * ------------------------------------------------------
 *     2: iload_1                   2: iinc          1, 1
 *     3: iinc                      5: iload_1
 *     6: istore_2                  6: istore_2
 *
 *
 *
 * 1、某些指令可以直接在抽屉里进行，比如inc指令，直接对抽屉里的数值进行+1操作
 * 2、局部变量表可以看做一个个的抽屉
 * 3、iload_1：从局部标量表(1号抽屉)压入栈顶；
 * 4、iinc： 在抽屉中进行+1的操作
 * 5、istore_2: 栈顶到局部标量表（即将栈顶的值赋值给a）
 *
 *
 *
 * ==================== 参考地址 =====================
 *
 * https://www.cnblogs.com/xpwi/p/11360692.html
 */
// @Slf4j
public class Test2 {

    /**
     * 上方
     */
    public void test1(){
        int i = 0;
        int a= i++;
        System.out.println(a); // a = 0
    }

    /**
     *  字节码分析
     *  stack=1, locals=4, args_size=1
     *          0: iconst_0   // 压入栈                                0
     *          1: istore_1   //存入到局部标量表slot_1                   0
     *          2: iload_1    // 从局部标量表slot_1元素压入操作栈         0
     *          3: iinc       // 局部变量表（抽屉）中执行inc指令          1
     *          6: istore_2   // 栈顶元素存入局部标量表slot_2中          a = 0;
     *          7: iload_1    // 从局部变量表中slot元素压入栈顶          1
     *          8: istore_3   // 栈顶元素到保存局部变量表slot_3          b = 1
     *          9: return
     */
    public void test3(){
        int i = 0;
        int a= i++;
        int b = i; // b = 1
    }

    /**
     * 上方
     */
    public void test2(){
        int i = 0;
        int a= ++i;  // a = 1
    }
}
