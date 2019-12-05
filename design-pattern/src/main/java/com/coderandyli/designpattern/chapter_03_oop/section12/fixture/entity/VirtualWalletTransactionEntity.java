package com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity;

import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.enums.Status;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-12-04
 * 虚拟交易流水
 */
@Data
public class VirtualWalletTransactionEntity {
    /**
     * id
     */
    private Long id;
    /**
     * 交易时间
     */
    private Long createTime;
    /**
     * 交易金额
     */
    private BigDecimal amount;
    /**
     * 钱包交易流水Id
     */
    private String walletTransactionId;
    /**
     *
     */
    private Long fromWalletId;

    private Long toWalletId;
    
    private Status status;

}
