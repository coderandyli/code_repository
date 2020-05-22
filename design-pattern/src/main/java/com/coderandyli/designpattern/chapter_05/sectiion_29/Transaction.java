package com.coderandyli.designpattern.chapter_05.sectiion_29;


import com.coderandyli.designpattern.chapter_05.sectiion_29.common.IdGenerator;
import com.coderandyli.designpattern.chapter_05.sectiion_29.common.RedisDistributedLock;
import com.coderandyli.designpattern.chapter_05.sectiion_29.common.STATUS;
import com.coderandyli.designpattern.chapter_05.sectiion_29.common.WalletRpcService;

import javax.transaction.InvalidTransactionException;

/**
 * Transaction 是经过我抽象简化之后的一个电商系统的交易类，用来记录每笔订单交易的情况。Transaction 类中的 execute() 函数负责执行转账操作，将钱从买家的钱包转到卖家的钱包中
 */
public class Transaction {
    private Long id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private Long orderId;
    private Long createTimestamp;
    private Double amount = 100d;
    private STATUS status;
    private Long walletTransactionId;

    /**
     * 为增加可测试性，通过依赖注入的方式，将WalletRpcService的创建反转到上层逻辑，
     * 真实环境中，分布式锁也可以参照修改
     */
    private WalletRpcService walletRpcService;

    public Transaction(Long preAssignedId, Long buyerId, Long sellerId, Long productId, Long orderId) {
        if (preAssignedId != null) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateId();
        }

        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }

    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - this.createTimestamp > 14;
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || (sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException();
        }
        if (status == STATUS.EXECUTED) return true;

        // transaction been exoired
        if (isExpired()) {
            this.status = STATUS.EXPIRED;
            return false;
        }

        boolean isLocked = false;
        try {
            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED) return true; // double check

            Long walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                RedisDistributedLock.getSingletonIntance().unlockTransction(id);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public STATUS getStatus() {
        return status;
    }

    public Long getWalletTransactionId() {
        return walletTransactionId;
    }

    // 为增加扩展性，通过依赖注入的方式，将WalletRpcService的创建反转到上层逻辑
    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }
}
