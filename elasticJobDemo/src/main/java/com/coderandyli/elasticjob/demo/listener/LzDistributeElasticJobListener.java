package com.coderandyli.elasticjob.demo.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-08-20
 */
@Slf4j
public class LzDistributeElasticJobListener extends AbstractDistributeOnceElasticJobListener {

    public LzDistributeElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds){
        super(startedTimeoutMilliseconds,completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        log.info(shardingContexts.getJobName() + " LzDistributeElasticJobListener doBeforeJobExecutedAtLastStarted...");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        log.info(shardingContexts.getJobName() + " LzDistributeElasticJobListener doAfterJobExecutedAtLastCompleted...");
    }
}
