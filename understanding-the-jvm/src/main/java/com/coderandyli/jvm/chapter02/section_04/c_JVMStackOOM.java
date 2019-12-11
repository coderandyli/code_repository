package com.coderandyli.jvm.chapter02.section_04;

/**
 * Created by lizhen on 2019-12-09
 * <p>
 *
 * 多线程下，jvm栈OOM
 *
 * VM args
 * -Xss2M
 *
 * 结果
 * 未抛出OOM, 但电脑卡顿严重
 *
 * 结论
 *  ""
 *
 *
 */
public class c_JVMStackOOM {
    private void dontStop() {
        while (true) {
            System.out.println("dontStop");
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String args[]) {
        c_JVMStackOOM oom = new c_JVMStackOOM();
        oom.stackLeakByThread();
    }
}
