package com.coderandyli.elasticjob.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.coderandyli.elasticjob.demo.entity.ExecutionLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * job execution log
 *
 * @author Hanping QIAO
 * @date 2018-09-26 16:25:40
 */
@Mapper
public interface ExecutionLogMapper extends BaseMapper<ExecutionLog> {

}
