package com.coderandyli.elasticjob.demo.job;

import com.coderandyli.elasticjob.demo.fixture.entity.Foo;
import com.coderandyli.elasticjob.demo.fixture.repository.FooRepository;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lizhen on 2019-08-20
 */
@Slf4j
public class LzDataflowJob implements DataflowJob<Foo> {


    @Resource
    private FooRepository fooRepository;

    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        log.info("Item: {} | Time: {} | Thread: {} | {}",
                shardingContext.getShardingItem(),
                new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(), "DATAFLOW FETCH");

        log.info("ShardingParameter() = {}", shardingContext.getShardingParameter());
        return fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        log.info("Item: {} | Time: {} | Thread: {} | {}",
                shardingContext.getShardingItem(),
                new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(),
                "DATAFLOW PROCESS");
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
        }
    }

//    @Override
//    public List<Integer> fetchData(ShardingContext shardingContext) {
//        return null;
//    }
//
//    @Override
//    public void processData(ShardingContext shardingContext, List<Integer> list) {
//    }
}
