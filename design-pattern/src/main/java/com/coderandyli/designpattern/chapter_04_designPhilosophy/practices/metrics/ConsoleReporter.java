package com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics;

import com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics.model.RequestInfo;
import com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics.model.RequestStat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/3 上午9:52
 *
 * 发送捅进数据到命令行
 */

public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
                long endTimestamp = System.currentTimeMillis();
                long startTimestamp = endTimestamp - durationInSeconds*1000;
                Map<String, List<RequestInfo>> allRequestInfos =     metricsStorage.getAllRequestInfosByDuration(startTimestamp, endTimestamp);
                System.out.println("Time Span: [" + startTimestamp + ", " + endTimestamp + "]");
                Map<String, RequestStat> requestStats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : allRequestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    // 第2个代码逻辑：根据原始数据，计算得到统计数据；
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInSeconds);
                    requestStats.put(apiName, requestStat);
                }
                // 第3个代码逻辑：将统计数据显示到终端（命令行或邮件）；
//                Gson gson = new Gson();
//                System.out.println(gson.toJson(requestStats));
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}

//// EmailReporter类的代码实现与Console类似，就没有给出了
//public class EmailReporter {
//    private MetricsStorage metricsStorage;
//    private ScheduledExecutorService executor;
//
//    public EmailReporter(MetricsStorage metricsStorage) {
//        this.metricsStorage = metricsStorage;
//        this.executor = Executors.newSingleThreadScheduledExecutor();
//    }
//
//    public void startDailyReport() {
//        executor.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                //...
//            }
//        }, 0, 24, TimeUnit.HOURS);
//    }
//}