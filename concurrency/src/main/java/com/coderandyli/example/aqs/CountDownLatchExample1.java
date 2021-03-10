package com.coderandyli.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhen on 2019-09-03
 *
 * CountDownLatch是一个非常实用的多线程控制工具类
 */
@Slf4j
public class CountDownLatchExample1 {

    public static void main(String args[]) {

        CountDownLatch countDownLatch = new CountDownLatch(3);//实例化一个倒计数器，count指定计数个数

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            log.info("Thread.currentThread().getName() = {}", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown(); // 计数减1
        });

        executorService.execute(() -> {
            log.info("Thread.currentThread().getName() = {}", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown(); // 计数减1
        });

        executorService.execute(() -> {
            log.info("Thread.currentThread().getName() = {}", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown(); // 计数减1
        });

        try {
            countDownLatch.await(); // 等待，当计数减到0时，继续往下执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        log.info("执行完毕");

    }
}
