package com.coderandyli.asserts;

/**
 * Created by lizhen on 2019-12-13
 * assertion 默认是关闭的，VM arg: -ea； 一般用于开发或测试环境
 *
 * 表达式
 * ```
 * assert expression1; // expression1 = false,抛出  Exception in thread "main" java.lang.AssertionError
 * ```
 *
 */
public class Main {
    public static void main(String args[]) {
        String str = "andy1";
        assert "andy".equals(str);
        System.out.println("hello assert");
    }
}
