package com.coderandyli.designpattern.chapter_03_oop.section12.ddd.domain;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-12-04
 * <p>
 * 虚拟钱包Domain领域模型（充血模型）
 */
public class VirtualWalletDo {
    /**
     * id
     */
    private Long id;
    /**
     * 创建时间
     */
    private Long createTime = System.currentTimeMillis();
    /**
     * 余额
     */
    private BigDecimal balance = BigDecimal.ZERO;
    /**
     * 是否允许超支
     */
    private boolean isAllowedOverdraft = true;
    /**
     * 超支金额
     */
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWalletDo() {
    }

    public VirtualWalletDo(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public void freeze(BigDecimal amount) {

    }

    public void unfreeze(BigDecimal amount) {

    }

    public void increaseOverdraftAmount(BigDecimal amount) {

    }

    public void decreaseOverdraftAmount(BigDecimal amount) {

    }

    public void closeOverdraft() {

    }

    public void openOverdraft() {

    }

    /**
     * 查询可用余额
     * @return
     */
    public BigDecimal getAvaliableBalance() {
        BigDecimal totalAvaliableBalance = this.balance.subtract(this.frozenAmount);
        if (isAllowedOverdraft) {
            totalAvaliableBalance = totalAvaliableBalance.add(this.overdraftAmount);
        }
        return totalAvaliableBalance;
    }

    /**
     * 出账
     *
     * @param amount
     */
    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            //throw new NoSufficientBalanceException(...);
        }
        this.balance.subtract(amount);
    }

    /**
     * 入账
     *
     * @param amount
     */
    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            // throw new InvalidAmountException(...);
        }
        this.balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
