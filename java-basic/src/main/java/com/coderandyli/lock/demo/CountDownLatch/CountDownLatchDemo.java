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

            // doSomethingElse();            // don't let run yet
            System.out.println("doSomethingElse， startSignal即将减一");
            startSignal.countDown();      // let all threads proceed
            System.out.println("startSignal已释放");
            // doSomethingElse();
            doneSignal.await();           // wait for all to finish
            System.out.println("Worker 已经执行完毕...");
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

