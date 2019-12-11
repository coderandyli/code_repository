package com.coderandyli.jvm.chapter02.section_04;

/**
 * Created by lizhen on 2019-12-09
 *
 * 测试 StackOverflowError
 *
 * VM args
 * -Xss1024k
 *
 * 结果
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 * 	at com.coderandyli.jvm.chapter02.section_04.b_JVMStackSOF.stackLeak(b_JVMStackSOF.java:18)
 *
 * 结论
 *  在单线程下，无论是由于栈帧太大还是虚拟机容量太小，当内存无法分配时，虚拟机抛出的都是StackOverflowError异常
 *
 */
public class b_JVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String args[]) {
        b_JVMStackSOF oom = new b_JVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
