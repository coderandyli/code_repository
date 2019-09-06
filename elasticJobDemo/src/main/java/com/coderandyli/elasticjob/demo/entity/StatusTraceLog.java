package com.coderandyli.elasticjob.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * job status trace log
 *
 * @author Hanping QIAO
 * @date 2018-09-26 16:24:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("job_status_trace_log")
public class StatusTraceLog extends Model<StatusTraceLog> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 任务名称
	 */
	private String jobName;
	/**
	 * 任务原始ID
	 */
	private String originalTaskId;
	/**
	 * 任务ID
	 */
	private String taskId;
	/**
	 * 子任务ID
	 */
	private String slaveId;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 任务类型
	 */
	private String executionType;
	/**
	 * 分片内容
	 */
	private String shardingItem;
	/**
	 * 任务状态
	 */
	private String state;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 创建时间
	 */
	private Date creationTime;

  /**
   * primary key
   */
  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
