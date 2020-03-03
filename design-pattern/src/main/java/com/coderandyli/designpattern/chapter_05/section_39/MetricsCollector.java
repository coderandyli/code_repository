package com.coderandyli.designpattern.chapter_05.section_39;

import com.coderandyli.designpattern.chapter_05.section_39.model.RequestInfo;
import org.apache.commons.lang3.StringUtils;
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


    private MetricsStorage metricsStorage; // 基于接口而非实现编程

    public MetricsCollector() {
    }

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo){
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }



}
