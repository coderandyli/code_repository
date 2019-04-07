package com.coderandyli.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by lizhen on 2019-04-07
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
        long l = -1L << 5L; // 32
//        long l = -1L ^ (-1L << 5L);
        log.debug("{}", Long.toBinaryString(-1L));
        log.debug("左移运算符 {} - {}", l, Long.toBinaryString(l));

//        log.debug("二进制 -> 十进制: {} -> {}", Long.toBinaryString(l),  Long.valueOf(Long.toBinaryString(l), 2));
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
}
