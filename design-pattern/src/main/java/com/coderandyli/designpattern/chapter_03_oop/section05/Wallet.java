package com.coderandyli.designpattern.chapter_03_oop.section05;

import com.coderandyli.designpattern.utils.SnowflakeIdWorker;
import org.springframework.util.IdGenerator;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-11-18
 */

public class Wallet {
    private long id;
    private long createTime;
    private BigDecimal balance;
    private long balanceLastModifiedTime;
    // ...省略其他属性...

    public Wallet() {
        this.id = SnowflakeIdWorker.getInstance().generateId();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    // 注意：下面对get方法做了代码折叠，是为了减少代码所占文章的篇幅
    public long getId() { return this.id; }
    public long getCreateTime() { return this.createTime; }
    public BigDecimal getBalance() { return this.balance; }
    public long getBalanceLastModifiedTime() { return this.balanceLastModifiedTime;  }

    public void increaseBalance(BigDecimal increasedAmount) {
//        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
//            throw new InvalidAmountException("...");
//        }
        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void decreaseBalance(BigDecimal decreasedAmount) {
//        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
//            throw new InvalidAmountException("...");
//        }
//        if (decreasedAmount.compareTo(this.balance) > 0) {
//            throw new InsufficientAmountException("...");
//        }
        this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}
