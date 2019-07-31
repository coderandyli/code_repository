package com.coderandyli.project.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.coderandyli.project.enums.LinkEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author Andy
 * @date 2019-07-30 13:53:44
 */
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("link")
public class Link extends Model<Link> {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;
	/**
	 * 原始url
	 */
	private String originalUrl;
	/**
	 * 短url
	 */
	private String shortUrl;
	/**
	 * 系统：system; 自定义：custom
	 */
	private LinkEnum type;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	private Boolean idUsed;

	public Link() {

	}


	public void Link(){

	}

  /**
   * primary key
   */
  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
