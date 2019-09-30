package com.coderandyli.monitor_tuning.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-09-30
 *
 *   字符串池和类的静态变量存放位置测试
 * <p>
 * jdk1.7，类的静态变量转移到了java heap中
 * <p>
 * <p>
 * 测试结果
 * <p>
 * ================= jdk1.6 =================
 * <p>
 * 运行参数
 * -XX:PermSize=8M -XX:MaxPermSize=8M
 * 运行结果
 * java.lang.OutOfMemoryError: PermGen space
 * 结论
 * 字符串常量存放在永久代中
 * <p>
 * ================= jdk1.7 =================
 * <p>
 * 运行参数
 * -Xmx32M -Xms32M
 * -XX:PermSize=8M -XX:MaxPermSize=8M
 * 运行结果
 * java.lang.OutOfMemoryError: Java heap space
 * 结论
 * 字符串常量在堆（java heap）中
 * <p>
 * ================= jdk1.8 =================
 * 运行参数
 * -XX:PermSize=8M -XX:MaxPermSize=8M
 * 运行结果
 * java.lang.OutOfMemoryError: Java heap space
 * 结论
 * 字符串常量在堆（java heap）中
 * <p>
 * <p>
 * <p>
 * 结论：
 *  字符串池和类的静态变量存放到了堆中
 */
public class Test3 {

    // static String base = "string";

    public static void main(String[] args) {
        String base = "string";

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            System.out.println(base);
        }
    }
}
