package com.coderandyli.lock.demo.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @description: CountDownLatch JDK示例
 * @author: lizhenzhen
 * @date: 2021-04-29 17:04
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) {
        Driver driver = new Driver();
        try {
            driver.main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Driver {
        void main() throws InterruptedException {
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(10);

            for (int i = 0; i < 10; ++i) // create and start threads
                new Thread(new Worker(startSignal, doneSignal)).start();

            System.out.println("doSomethingElse， startSignal即将减一");
            startSignal.countDown();      // let all threads procee 让所有线程继续
            System.out.println("收到start信号，即将开始...");
            doneSignal.await();           // wait for all to finish 等待所有线程工作完成
            System.out.println("收到done信息，工作完成");
        }
    }

    static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException ex) {
            } // return;
        }

        void doWork() {
            System.out.println("do work");
        }
    }
}

