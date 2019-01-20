package com.coderandyli.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by lizhen on 2019-01-20
 */
@Slf4j
public class FutureTaskTest {

    public static void main(String args[]) throws Exception {
         log.debug(test2());
    }

    /**
     *
     * newCachedThreadPool + FutureTask
     *  -------- 模拟场景 --------
     *
     *  执行taskA， taskA包含taskB和taskC
     *
     */
    public static String test2() throws Exception {
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 获取数据A
        FutureTask<String> futureTaskB = new FutureTask<String>(()->{
            log.debug("exec taskB...");
            Thread.sleep(3000);
            return "taskB finish";
        });
        executorService.execute(futureTaskB);

        // 获取数据B
        FutureTask<String> futureTaskC = new FutureTask<String>(()->{
            log.debug("exec taskC...");
            Thread.sleep(4000);
            return "taskC finish";
        });
        executorService.execute(futureTaskC);

        log.debug("exec other task...");
        Thread.sleep(1000);

        log.debug("taskB Result : {}", futureTaskB.get());
        log.debug("taskC Result : {}", futureTaskC.get());
        log.debug("all task finnish, process the data");

        // 关闭线程
        executorService.shutdown();

        return "taskA finish";
    }

    public static void test() throws Exception {

         /*FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });*/

        // lambda 表达式写法
        FutureTask<String> futureTask = new FutureTask<>(()->{
            log.debug("do something in callable");
            Thread.sleep(5000);
            return "Done";
        });

        new Thread(futureTask).start();
        log.debug("do something in main");
        Thread.sleep(1000);
        log.debug("reuslt ： {}", futureTask.get());
    }
}
