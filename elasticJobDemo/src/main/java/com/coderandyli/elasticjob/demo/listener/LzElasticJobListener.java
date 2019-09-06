package com.coderandyli.elasticjob.demo.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-08-20
 */
@Slf4j
public class LzElasticJobListener implements ElasticJobListener {

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        log.info(shardingContexts.getJobName() + " LzElasticJobListener beforeJobExecuted...");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info(shardingContexts.getJobName() + " LzElasticJobListener afterJobExecuted...");
    }
}
