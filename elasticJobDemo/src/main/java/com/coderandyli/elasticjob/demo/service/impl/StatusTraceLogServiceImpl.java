package com.coderandyli.elasticjob.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.coderandyli.elasticjob.demo.entity.StatusTraceLog;
import com.coderandyli.elasticjob.demo.mapper.StatusTraceLogMapper;
import com.coderandyli.elasticjob.demo.service.StatusTraceLogService;
import org.springframework.stereotype.Service;


@Service("statusTraceLogService")
public class StatusTraceLogServiceImpl extends ServiceImpl<StatusTraceLogMapper, StatusTraceLog> implements StatusTraceLogService {

}
