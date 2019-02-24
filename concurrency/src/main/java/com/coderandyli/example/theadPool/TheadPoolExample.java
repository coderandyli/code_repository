package com.coderandyli.example.theadPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lizhen on 2019-01-20
 */
@Slf4j
public class TheadPoolExample {

    public static void main(String args[]) {
//        test4_1();
        // test4();
//         test3();
//         test2();
        // test();
    }

    @Async
    public void test5() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    /**
     * 定时器 Timer
     */
    public static void test4_1() {
        Timer timer = new Timer();

        // 每隔 3秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.debug("timer run");
            }
        }, new Date(), 3 * 1000);
    }

    /**
     * Executors.newScheduledThreadPool(5)
     * 调度线程池：创建一个定长线程池，支持定时以及周期性的任务执行
     */
    public static void test4() {
        // 创建线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        // 延迟3秒执行
        /*executorService.schedule(()->{
            log.debug("execute run");
        },3, TimeUnit.MICROSECONDS);*/

        // 延迟 1 秒，每隔 3 秒执行一次
        executorService.scheduleAtFixedRate(() -> {
            log.debug("execute run");
        }, 1, 3, TimeUnit.MICROSECONDS);

        // 关闭线程
        /*executorService.shutdown();*/
    }

    /**
     * Executors.newSingleThreadExecutor()
     * <p>
     * public static ExecutorService newSingleThreadExecutor() {
     * return new FinalizableDelegatedExecutorService
     * (new ThreadPoolExecutor(1, 1,
     * 0L, TimeUnit.MILLISECONDS,
     * new LinkedBlockingQueue<Runnable>()));
     * }
     * <p>
     * 创建一个单线程化的线程池，用唯一的一个线程执行任务
     */
    public static void test3() {
        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                log.debug("index: {}", index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程
        executorService.shutdown();
    }

    /**
     * Executors.newFixedThreadPool()
     * <p>
     * public static ExecutorService newFixedThreadPool(int nThreads) {
     * return new ThreadPoolExecutor(nThreads, nThreads,
     * 0L, TimeUnit.MILLISECONDS,
     * new LinkedBlockingQueue<Runnable>());
     * }
     * <p>
     * 创建一个定长的线程池，控制最大并发数，超出部分在队列中等待
     */
    public static void test2() {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                log.debug("index: {}", index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程
        executorService.shutdown();
    }

    /**
     * Executors.newCachedThreadPool()
     * <p>
     * public static ExecutorService newCachedThreadPool() {
     * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     * 60L, TimeUnit.SECONDS,
     * new SynchronousQueue<Runnable>());
     * }
     * <p>
     * 可缓存线程池
     */
    public static void test() {
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                log.debug("index: {}", index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程
        executorService.shutdown();
    }
}
