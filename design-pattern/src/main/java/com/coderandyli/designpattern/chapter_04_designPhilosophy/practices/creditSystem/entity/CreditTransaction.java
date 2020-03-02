package com.coderandyli.designpattern.chapter_04_designPhilosophy.practices.creditSystem.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author lizhen
 * @version 1.0
 * @date 2020/1/2 下午5:08
 * 积分交易明细表
 */
@Data
public class CreditTransaction {
    /**
     * 明细id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 赚取或消费渠道ID
     */
    private Long channelId;
    /**
     * 相关事件Id(比如 订单Id、评论Id、优惠券兑换交易Id)
     */
    private Long eventId;
    /**
     * 积分 （赚取为正值、消费为负值）
     */
    private Long credit;
    /**
     * 赚取或消费积分
     */
    private Date createTime;
    /**
     * 积分过期时间
     */
    private Date expiredTime;

}
