package com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.metrics.model;

import lombok.Data;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/3 上午10:28
 */
@Data
public class RequestInfo {
    /**
     * 接口名称
     */
    private String apiName;
    /**
     * 响应时间
     */
    private double responseTime;
    /**
     * 开始请求时间
     */
    private long timestamp;
}
