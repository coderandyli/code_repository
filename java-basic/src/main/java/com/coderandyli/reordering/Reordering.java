package com.coderandyli.reordering;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/3/9 下午5:57
 */
public class Reordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        test_01();
    }

    /**
     * 运行结果可能为(1,0)、(0,1)或(1,1) 因为线程one可以在线程two开始之前就执行完了，也有可能反之，甚至有可能二者的指令是同时或交替执行的。
     * 然而也可能是(0,0) 因为，在实际运行时，代码指令可能并不是严格按照代码语句顺序执行的, 也就是说发生了**指令重拍（reordering）**
     *
     * 线程one -----> x = b(0) ------------指令重排---------------> a = 1--> end
     * 线程two -----------------> b = 1 -----> y = a(0)------------------> end
     *
     * Java运行时环境的JIT编译器也会做指令重排序操作4，即生成的机器指令与字节码指令顺序不一致。
     *      - 在条件允许的情况下，直接运行当前有能力立即执行的后续指令，避开获取下一条指令所需数据时造成的等待3。通过乱序执行的技术，处理器可以大大提高执行效率
     */
    public static void test_01() throws InterruptedException{
        for (int i = 0; i < 10000; i++) {
            x = y = a = b = 0;
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            one.join();
            other.join();
            System.out.println("(" + x + "," + y + ")");
        }
    }
}
