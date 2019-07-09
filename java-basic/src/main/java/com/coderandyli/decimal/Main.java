package com.coderandyli.decimal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-06-22
 * <p>
 * java 中浮点数数据精度问题
 *
 * 将十进制浮点数转换为二进制浮点数时，小数的二进制有时也是不可能精确的，
 * 就如同十进制不能准确表示1/3，二进制也无法准确表示1/10，
 * 而double类型存储尾数部分最多只能存储52位，
 * 于是，计算机在存储该浮点型数据时，便出现了精度丢失（1）。
 * 例如，11.9的内存存储大约为：1011. 1110011001100110011001100...
 * 而在进行浮点类数据计算的时候，浮点参与计算，会左移或右移n位，
 * 直到小数点移动到第一个有效数字的右边。于是11.9在转化为二进制后 小数点左移3位，
 * 就得到1. 011 11100110011001100110（精度丢失2）
 * 于是最终浮点型运算出现了精度丢失误差。
 */
@Slf4j
public class Main {

    /**
     * 不能将浮点型（float、Double）直接传给BigDecimal，
     * 否则不断无法解决精度问题，反而对精度进行了补全。
     * 所以，为确保精度，我们将String传给它。
     */
    @Test
    public void test01() {
        float f1 = 12.0f;
        float f2 = 11.9f;
        log.info("【Error demonstration】： f1 - f2 = {}", f1 - f2);

        BigDecimal b1 = new BigDecimal(f1); //new BigDecimal(Float.toString(f1));
        BigDecimal b2 = new BigDecimal(f2); //new BigDecimal(Float.toString(f2));
        log.info("【Error demonstration】：b1.subtract(b2).toString() = {}", b1.subtract(b2).toString());

        BigDecimal b3 = new BigDecimal(Float.toString(f1));
        BigDecimal b4 = new BigDecimal(Float.toString(f2));
        log.info("【Proper demonstration】：b3.subtract(b4).toString() = {}", b3.subtract(b4).toString());

    }

    /***
     * 加、减、乘、除
     */
    @Test
    public void test02() {
        float f1 = 3.31f;
        float f2 = 2.2f;

        BigDecimal b1 = new BigDecimal(Float.toString(f1));
        BigDecimal b2 = new BigDecimal(Float.toString(f2));

        // 加
        log.info("b1.add(b2).toString() = {}", b1.add(b2).toString());

        // 减
        log.info("b1.subtract(b2).toString() = {}", b1.subtract(b2).toString());

        // 乘
        log.info("b1.multiply(b2).toString() = {}", b1.multiply(b2).toString());

        log.info("--------------------------------------");

        // 除
        // BigDecimal.ROUND_HALF_DOWN 四舍五入
        BigDecimal divide = b1.divide(b2, 20, BigDecimal.ROUND_HALF_DOWN);
        log.info("divide.intValue() = {}", divide.intValue());
        log.info("divide.longValue() = {}", divide.longValue());
        log.info("divide.floatValue() = {}", divide.floatValue());
        log.info("divide.doubleValue() = {}", divide.doubleValue());
        log.info("divide.toString() = {}", divide.toString());
    }

    @Test
    public void test03(){
        double a = 0.4f;
        double b = 0.2f;
        System.out.println(a + b);
    }
}
