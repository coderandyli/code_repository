package com.coderandyli.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by lizhen on 2019-04-07
 *
 * ****************** 位运算符 ******************
 *
 * -1 二进制
 * 原码：1000 0000 0000 0001（其中第一个1为符号位）
 * 反码：1111 1111 1111 1110 （符号位不变，其余的取反）
 * 补码：1111 1111 1111 1111 （原码取反+1 ，符号位不变）
 *
 * 在计算机中负数是补码表示的
 *
 */
@Slf4j
public class Main {

    /**
     * 移位运算符
     *    <<  左移运算符
     *
     */
    @Test
    public void test1(){

        // 计算机中负数是补码表示的
        log.debug("{}", Long.toBinaryString(-1L));

        long l = -1L << 5L; // -32
        log.debug("左移运算符 十进制 - 二进制 -> {} - {}", l, Long.toBinaryString(l));
    }

    /**
     * 异或运算符
     *  1001
     *  1100
     * ------
     *  0101
     */
    @Test
    public void test2(){
        int a = 9; // 1001
        int b = 12; //1100
        log.debug("a ^ b = {}", a ^ b); // 0101(2)
    }

    /**
     * | 按位或云算符
     * 运算规则：将两个数据的二进制表示右对齐后，按位进行运算，两个对应的二进制位中只要一个是1
     *  eg：
     *  1001
     *  1100
     * ------
     *  1101
     */
    @Test
    public void test3(){
        int a = 9;
        int b = 12;
        log.debug("a | b = {}", Integer.toBinaryString(a | b));
    }
}
