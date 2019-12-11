package com.coderandyli.jvm.chapter02.section_04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-12-09
 *
 * ================== jdk6 ==================
 * VM Args
 * -XX:PermSize=8M -XX:MaxPermSize=8M
 *
 * 运行结果
 *  java.lang.OutOfMemoryError: PermGen space
 *
 * 结论
 *  jdk6 intern()方法把首次遇到的字符串实例复制到（永久代的/方法区的）运行时常量池中的字符串常量池中，所有在永久代10M的空间内，很快内存溢出；
 *
 * ================== jdk7 ==================
 * VM Args
 *  -XX:PermSize=8M -XX:MaxPermSize=8M
 *
 * 运行结果
 *  运行正常
 *
 * 结论
 *  jdk7之后 字符串常量池放在了堆中,intern()方法不在复制首次遇到的字符串实例，而是记录其实例引用，所以运行正常
 *
 */
public class d_RuntimeConstantPootOOM {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            String intern = String.valueOf(i++).intern();
            list.add(intern);
            System.out.println(intern);
        }
    }
}
