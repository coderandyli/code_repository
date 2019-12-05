package com.coderandyli.designpattern.chapter_03_oop.section12.fixture.controller;

import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.vo.VirtualWalletVo;
import com.coderandyli.designpattern.chapter_03_oop.section12.mvc.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-12-04
 */
public class VirtualWalletController {


    @Autowired
    private VirtualWalletService virtualWalletService;

    //查询余额
    public BigDecimal getBalance(Long walletId) {
        return null;
    }

    public VirtualWalletVo getWallet(Long walletId){

        return null;
    }

    //出账
    public void debit(Long walletId, BigDecimal amount) {
    }

    //入账
    public void credit(Long walletId, BigDecimal amount) {
    }

    //转账
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
    }


}
