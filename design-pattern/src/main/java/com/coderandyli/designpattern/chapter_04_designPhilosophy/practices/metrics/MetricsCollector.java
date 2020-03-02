package com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics;

import com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics.model.RequestInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/3 上午9:48
 *
 * 提供API, 采集接口请求的原始数据
 */
@Component
public class MetricsCollector {

    @Autowired
    private MetricsStorage metricsStorage; // 基于接口而非实现编程

    public void recordRequest(RequestInfo requestInfo){
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }



}
