package com.coderandyli.designpattern.chapter_03_oop.section12.mvc.bo;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-12-04
 */
public class VirtualWalletBo {
    /**
     * id
     */
    private Long id;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 余额
     */
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
