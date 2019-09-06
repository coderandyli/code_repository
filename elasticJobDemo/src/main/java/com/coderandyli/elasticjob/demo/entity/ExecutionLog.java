package com.coderandyli.elasticjob.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * job execution log
 *
 * @author Hanping QIAO
 * @date 2018-09-26 16:25:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("job_execution_log")
public class ExecutionLog extends Model<ExecutionLog> {
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
	 * 任务ID
	 */
	private String taskId;
	/**
	 * 主机名称
	 */
	private String hostname;
	/**
	 * 主机地址
	 */
	private String ip;
	/**
	 * 分片内容
	 */
	private Integer shardingItem;
	/**
	 * 执行源
	 */
	private String executionSource;
	/**
	 * 失败原因
	 */
	private String failureCause;
	/**
	 * 是否成功
	 */
	private Integer isSuccess;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 完成时间
	 */
	private Date completeTime;

  /**
   * primary key
   */
  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
