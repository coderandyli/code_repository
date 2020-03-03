package com.coderandyli.designpattern.chapter_05.section_39;

import com.coderandyli.designpattern.chapter_05.section_39.model.RequestInfo;
import com.coderandyli.designpattern.chapter_05.section_39.model.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/3 上午9:52
 * <p>
 * 根据原始数据进行聚合计算
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis/1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        return 0d;
    }
    private double min(List<Double> dataset) {
        return 0d;
    }
    private double avg(List<Double> dataset) {
        return 0d;
    }
    private double tps(int count, double duration) {
        return 0d;
    }
    private double percentile999(List<Double> dataset) {
        return 0d;
    }
    private double percentile99(List<Double> dataset) {
        return 0d;
    }
    private double percentile(List<Double> dataset, double ratio) {
        return 0d;
    }
}


//public class Aggregator {
//
//    /**
//     * 聚合统计
//     * @param requestInfos
//     * @param durationInSeconds
//     * @return
//     */
//    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInSeconds) {
//        double maxRespTime = Double.MIN_VALUE, minRespTime = Double.MAX_VALUE, avgRespTime = -1, p999RespTime = -1, p99RespTime = -1, sumRespTime = -1;
//        long count = 0;
//
//        for (RequestInfo requestInfo : requestInfos) {
//            ++count;
//            double respTime = requestInfo.getResponseTime();
//            if (maxRespTime < respTime) {
//                maxRespTime = respTime;
//            }
//            if (minRespTime > respTime) {
//                minRespTime = respTime;
//            }
//            sumRespTime += respTime;
//        }
//
//        if (count != 0) {
//            avgRespTime = sumRespTime / count;
//        }
//        long tps = (long) (sumRespTime / durationInSeconds);
//
//        // asc
//        requestInfos.sort((o1, o2) -> {
//            double diff = o1.getResponseTime() - o2.getResponseTime();
//            return Double.compare(diff, 0.0);
//        });
//
//        if (count != 0){
//            int idx999 = (int)(count*0.999);
//            int idx99 = (int)(count*0.99);
//            p999RespTime = requestInfos.get(idx999).getResponseTime();
//            p99RespTime = requestInfos.get(idx99).getResponseTime();
//        }
//        return new RequestStat(maxRespTime, minRespTime, avgRespTime, p999RespTime, p99RespTime, count, tps);
//    }
//
//}
