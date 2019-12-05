package com.coderandyli.designpattern.chapter_03_oop.section12.mvc.service.impl;

import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity.VirtualWalletEntity;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity.VirtualWalletTransactionEntity;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.exception.InsufficientBalanceException;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.repository.VirtualWalletRepository;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.repository.VirtualWalletTransactionRepository;
import com.coderandyli.designpattern.chapter_03_oop.section12.mvc.bo.VirtualWalletBo;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.enums.Status;
import com.coderandyli.designpattern.chapter_03_oop.section12.mvc.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-12-04
 */
@Service
public class VirtualWalletServiceImpl implements VirtualWalletService {

    @Autowired
    private VirtualWalletRepository walletRepo;

    @Autowired
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity);
        return walletBo;
    }

    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
            //throw new NoSufficientBalanceException(...);
        }
        walletRepo.updateBalance(walletId, balance.subtract(amount));
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        walletRepo.updateBalance(walletId, balance.add(amount));
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(Status.TO_BE_EXECUTED);
        Long transactionId = transactionRepo.saveTransaction(transactionEntity);
        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (InsufficientBalanceException e) {
            transactionRepo.updateStatus(transactionId, Status.CLOSED);
            // ...rethrow exception e...
        } catch (Exception e) {
            transactionRepo.updateStatus(transactionId, Status.FAILED);
            // ...rethrow exception e...
        }
        transactionRepo.updateStatus(transactionId, Status.EXECUTED);
    }

    private VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
        VirtualWalletBo bo = new VirtualWalletBo();
        return bo;
    }
}
