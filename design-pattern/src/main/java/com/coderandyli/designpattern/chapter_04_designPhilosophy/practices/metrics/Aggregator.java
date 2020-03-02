package com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics;

import com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics.model.RequestInfo;
import com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics.model.RequestStat;

import java.util.List;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/3 上午9:52
 * <p>
 * 根据原始数据进行聚合计算
 */
public class Aggregator {

    /**
     * 聚合统计
     * @param requestInfos
     * @param durationInSeconds
     * @return
     */
    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInSeconds) {
        double maxRespTime = Double.MIN_VALUE, minRespTime = Double.MAX_VALUE, avgRespTime = -1, p999RespTime = -1, p99RespTime = -1, sumRespTime = -1;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }

        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (long) (sumRespTime / durationInSeconds);

        // asc
        requestInfos.sort((o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            return Double.compare(diff, 0.0);
        });

        if (count != 0){
            int idx999 = (int)(count*0.999);
            int idx99 = (int)(count*0.99);
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        return new RequestStat(maxRespTime, minRespTime, avgRespTime, p999RespTime, p99RespTime, count, tps);
    }

}
