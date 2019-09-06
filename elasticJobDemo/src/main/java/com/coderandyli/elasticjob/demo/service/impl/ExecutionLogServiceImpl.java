package com.coderandyli.elasticjob.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.coderandyli.elasticjob.demo.entity.ExecutionLog;
import com.coderandyli.elasticjob.demo.mapper.ExecutionLogMapper;
import com.coderandyli.elasticjob.demo.service.ExecutionLogService;
import org.springframework.stereotype.Service;


@Service("executionLogService")
public class ExecutionLogServiceImpl extends ServiceImpl<ExecutionLogMapper, ExecutionLog> implements ExecutionLogService {

}
