package com.coderandyli.monitor_tuning.test;

import com.coderandyli.monitor_tuning.chapter1.Metaspace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-09-30
 *
 * ================ jdk7 ===============
 * 运行环境
 *  -XX:PermSize=8M -XX:MaxPermSize=8M
 * 运行结果
 *  java.lang.OutOfMemoryError: PermGen space
 * 结论
 *  JVM的实现中将类的元数据放入永久代中,
 *
 * ================ jdk8 ===============
 *
 * 运行参数
 *  -XX:MetaspaceSize=32m -XX:MaxMetaspaceSize=32m
 * 运行结果
 *  java.lang.OutOfMemoryError: Metaspace
 * 结论
 *  JVM的实现中将类的元数据放入 native memory(本地内存中),
 */
public class Test4 {

    public static void main(String args[]) {
        List<Class<?>> classList = new ArrayList<>();
        while (true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}
