package com.coderandyli.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by lizhen on 2019-01-20
 *
 * https://baijiahao.baidu.com/s?id=1630613195863161441&wfr=spider&for=pc
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

        long startTime = System.currentTimeMillis();

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3); //Executors.newCachedThreadPool();

        // 获取数据A
        FutureTask<String> futureTaskB = new FutureTask<>(()->{
            log.debug("exec taskB...");
            Thread.sleep(3000);
            return "taskB finish";
        });
        executorService.execute(futureTaskB);

        // 获取数据B
        FutureTask<String> futureTaskC = new FutureTask<>(()->{
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

        long endTime = System.currentTimeMillis();
        log.debug("执行时间：{}", endTime - startTime);

        return "taskA finish";
    }
}
