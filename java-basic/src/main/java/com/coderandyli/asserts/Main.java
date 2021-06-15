package com.coderandyli.asserts;

/**
 * Created by lizhen on 2019-12-13
 *
 * - assertion 默认是关闭的，VM arg: -ea； 一般用于开发或测试环境
 * - 断言失败时会抛出AssertionError，导致程序结束退出。因此，断言不能用于可恢复的程序错误，只应该用于开发和测试阶段。
 *
 * 表达式
 * ```
 * assert expression1; // expression1 = false,抛出  Exception in thread "main" java.lang.AssertionError
 * ```
 *
 * Reference
 * - https://www.liaoxuefeng.com/wiki/1252599548343744/1264740093521088
 */
public class Main {
    public static void main(String args[]) {
        String str = "andy2";
        assert "andy".equals(str) : "the name is incorrect.";
        System.out.println("hello assert");
    }
}
