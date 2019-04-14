package com.coderandyli.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * Created by lizhen on 2019-04-14
 *
 * @Retention : 注解（MyAnnotaion）的运行周期
 *  1.几种类型
 *      1> RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 *      2> RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 *      3> RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 *      这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
 *      生命周期长度 SOURCE < CLASS < RUNTIME, 所以前者能作用到的地方后者也能作用到
 *  2.如何选择
 *       1> 如果需要在运行时动态获取注解信息，那么只能使用RUNTIME注解;
 *       2> 如果需要在编译时进行一些预处理操作，比如生成一些辅助代码, 就用CLASS注解;
 *       3> 如果只是做一些检查性的操作，比如 @Override 和 @SuppressWarnings，则可选用 SOURCE 注解;
 *
 * @Target: 注解的适用范围
 *  1> ElementType.TYPE：适用类、接口（包括注解类型）或枚举
 *  2> ElementType.FIELD: 适用field属性，也包括enum常量
 *  3> ElementType.METHOD: 适用方法
 *
 */
@Order(1)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface MyAnnotation {

    String value() default "";
}
