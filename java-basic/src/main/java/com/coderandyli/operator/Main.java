package com.coderandyli.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by lizhen on 2019-04-07
 * <p>
 * ****************** 位运算符 ******************
 * <p>
 * -1 二进制
 * 原码：1000 0000 0000 0001（其中第一个1为符号位）
 * 反码：1111 1111 1111 1110 （符号位不变，其余的取反）
 * 补码：1111 1111 1111 1111 （原码取反+1 ，符号位不变）
 * <p>
 * 在计算机中负数是补码表示的
 *
 * 参考地址: https://blog.csdn.net/xiaopihaierletian/article/details/78162863
 */
@Slf4j
public class Main {

    /**
     * 移位运算符
     * <<  左移运算符
     *
     */
    @Test
    public void test01() {
        int leftShift = 10;
        System.out.println("十进制:" + leftShift + ", 二进制:" + Integer.toBinaryString(leftShift));
        int newLeftShift = leftShift << 3;
        System.out.println("左移2位后十进制:" + newLeftShift + ", 左移2位后二进制" + Integer.toBinaryString(newLeftShift));    //正整数x左移n位后的十进制结果，x = x * 2^n
        double pow = Math.pow(2, 3); // 2的2次方
        System.out.println("leftShift左移2位 <==> leftShift * 2的2次方(2^2)，及" + leftShift * pow);
    }

    /**
     * 计算机中负数是补码表示的
     * 为什么会-10的二进制会出现这么多的1呢？仔细数一下刚好有32位。
     * 首先需要了解的是Java负数存储是以补码形式存储的（补码=反码+1），
     * 10的二进制是1010，它的反码就是0101，再加1就是补码0110。
     * 那为什么会多出来那么多1呢？这是因为int型在Java中占8个字节，
     * 刚好32位，10原码的高位全是0，它的反码自然高位就变成了1。
     * 所以整体左移2位，低位以0补齐，最后的运算结果就是x = (|x| + 2^n)。
     *
     * >>  右位移运算符 ： 有符号右移位，将运算数的二进制整体右移指定位数，整数高位用0补齐，负数高位用1补齐（保持负数符号不变）
     */
    @Test
    public void test02() {
        log.debug("{}", Long.toBinaryString(-80L));
        long l = -80L >> 3L; // -32
        log.debug("右运算符 十进制 - 二进制 -> {} - {}", l, Long.toBinaryString(l));
    }

    /**
     * >>> 无符号右移，不管正数还是负数，高位都用0补齐（忽略符号位）
     *
     *  1. 正数的>>>无符号右移位和>>有符号右移位计算结果相同
     *  2. 负数的>>>无符号右移位和>>有符号右移位计算结果大不同
     *
     */
    @Test
    public void test(){
        int rightShift = 80;
        log.debug("无符号右移 十进制 - 二进制 -> {} - {}", rightShift >>> 3, Long.toBinaryString(rightShift >>> 3));
        log.debug("有符号右移 十进制 - 二进制 -> {} - {}", rightShift >> 3, Long.toBinaryString(rightShift >> 3));

        log.debug("------------------------------------------------------------");

        int rightShift2 = -80;
        log.debug("无符号右移 十进制 - 二进制 -> {} - {}", rightShift2 >>> 3, Long.toBinaryString(rightShift2 >>> 3));
        log.debug("有符号右移 十进制 - 二进制 -> {} - {}", rightShift2 >> 3, Long.toBinaryString(rightShift2 >> 3));
    }

    /**
     * | 按位或运算符
     * 运算规则：将两个数据的二进制表示右对齐后
     *      0|0=0；  0|1=1；  1|0=1；   1|1=1；
     *      即 ：参加运算的两个对象只要有一个为1，其值为1。
     * eg：
     * 1001
     * 1100
     * ------
     * 1101
     */
    @Test
    public void test03() {
        int a = 9;
        int b = 12;
        log.debug("a | b = {}", Integer.toBinaryString(a | b));
    }

    /**
     * 按位与运算符（&）
     *      运算规则：0&0=0;  0&1=0;   1&0=0;    1&1=1;
     *      即：两位同时为“1”，结果才为“1”，否则为0
     * eg:
     * 0000 0011        3
     * 0000 0101        5
     * ---------
     * 0000 0001
     *
     * 特殊用途
     * （1）清零。如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都为零的数值相与，结果为零
     *
     */
    @Test
    public void test04(){
        int a = 3;
        int b = 5;
        log.debug("a & b = {}", Integer.toBinaryString(a & b));
    }

    /**
     * 异或运算符
     *    运算规则：0^0=0；  0^1=1；  1^0=1；   1^1=0；
     *    即：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。
     *
     * 1001
     * 1100
     * ------
     * 0101
     */
    @Test
    public void test05() {
        int a = 9; // 1001
        int b = 12; //1100
        log.debug("a ^ b = {}", a ^ b); // 0101(2)
    }

    /**
     *
     */
    @Test
    public void test06(){
        double pow = Math.pow(2, 10); // 2^31
        System.out.println(pow);
    }
}
