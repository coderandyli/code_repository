package com.coderandyli.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by lizhen on 2019-08-29
 *
 * 使用AtomicBoolean模拟CAS操作
 */
@Slf4j
public class AtomicBooleanTest {

    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static int count = 0;

    public static void main(String args[]) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    if (flag.compareAndSet(true, false)) {
                        count++;
                        flag.set(true);
                        log.info("exec count++; currentThread: {}; flag: {}", Thread.currentThread().getName(), flag.get());
                    } else {
                        log.info("重试 currentThread: {}; flag: {}", Thread.currentThread().getName(), flag.get());
                        run();
                    }
                }
            });
        }
        // 关闭线程
        executorService.shutdown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("count = {}", count);
    }
}
