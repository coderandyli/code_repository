package com.coderandyli.designpattern.chapter_05.section_40;

import com.coderandyli.designpattern.chapter_05.section_40.model.RequestInfo;
import com.coderandyli.designpattern.chapter_05.section_40.storage.RedisMetricsStorage;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/3 上午9:48
 * <p>
 * 提供API, 采集接口请求的原始数据
 *
 * 为防止一次性加载太多数据到内存，导致内存吃紧，甚至内存溢出
 *      采用 Google Guava EventBus 生产者-消费者模型，将采集的数据先放入内存共享队列中，另一个县城读取共享队列中的数据，写入到外部存储中，
 */
@Component
public class MetricsCollector {
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;

    private MetricsStorage metricsStorage; // 基于接口而非实现编程

    private EventBus eventBus;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        eventBus.post(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }


}
