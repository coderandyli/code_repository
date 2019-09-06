package com.coderandyli.elasticjob.demo.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-08-20
 */
@Slf4j
public class LzSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {

        int shardingItem = shardingContext.getShardingItem();
        log.info(shardingContext.getJobName() + " LzSimpleJob execute...");
        log.info("shardingIndex: {}", shardingContext.getShardingItem());
        switch (shardingItem) {
            case 0:
                log.info("LzSimpleJob starting 0....");
                break;
            case 1:
                log.info("LzSimpleJob starting 1....");
                break;
            case 2:
                log.info("LzSimpleJob starting 2....");
                break;
            default:
                break;
        }
    }
}
