package com.coderandyli.jvm.chapter04;

/**
 * Created by lizhen on 2019-12-23
 *
 * 线程死锁演示：大概运行2到3次，将会发生死锁，程序不会结束
 *
 * 当发生死锁时，使用JConsole 检测死锁
 *
 */
public class DeadLock implements Runnable {
    int a, b;

    public DeadLock(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a+b);
            }
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            new Thread(new DeadLock(1,2)).start();
            new Thread(new DeadLock(2,1)).start();
        }
    }
}
