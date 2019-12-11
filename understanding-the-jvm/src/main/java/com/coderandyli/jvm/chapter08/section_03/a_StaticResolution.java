package com.coderandyli.jvm.chapter08.section_03;

/**
 *
 * Created by lizhen on 2019-11-28
 *

 *
 *
 * 方法调用 之 解析调用
 *
 * 方法静态解析（解析调用）演示
 *
 * 1.测试前知识
 *   方法调用之解析：所有方法调用中的目标方法在Class文件里面都是一个常量池中
 *   的符号引用，在类加载的解析阶段，会将其中的一部分符号引用转换为直接引用，
 *   即“编译期可知，运行期不可变”， 满足这个要求的方法主要包括静态方法和私有方法两大类。
 *  JVM中调用方法的五条指令
 *      - invokestatic 调用静态方法
 *      - invokespecial 调用实例构造器<init>方法，私有方法和父类方法
 *      - invokevirtual 调用所有的虚方法
 *      - invokeinterface 调用接口方法，会在运行时再确定一个实现此接口的对象
 *      - invokedynamic 先在运行时动态解析出调用点限定符所引用的方法，然后再执行该方法。
 *  只要被invokestatic 和 invokespecial 指令调用的方法，都可以在类加载时将符号引用解析为该方法的直接引用
 *  解析调用一定是静态的过程，在编译期间就完全确定。
 *
 *
 * 2、javap 查看字节码（如下），发现是通过invokestatic命令来调用sayHello()方法的
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=0, locals=1, args_size=1
 *          0: invokestatic  #2                  // Method sayHello:()V
 *          3: return
 *       LineNumberTable:
 *         line 20: 0
 *         line 21: 3
 *
 */
public class a_StaticResolution {

    public static void main(String args[]) {
        sayHello();
    }

    public static void sayHello() {
        System.out.println("hello word");
    }
}
