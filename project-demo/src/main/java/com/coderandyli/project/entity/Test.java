package com.coderandyli.project.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 
 *
 * @author Andy
 * @date 2019-07-30 13:53:44
 */
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("test")
public class Test extends Model<Test> {
	private static final long serialVersionUID = 1L;

	private long id;
	private int val;
	private int source;

	public Test() {

	}

	/**
   * primary key
   */
  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
