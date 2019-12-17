package com.coderandyli.designpattern.chapter_03_oop.section12.ddd.service.impl;

import com.coderandyli.designpattern.chapter_03_oop.section12.ddd.domain.VirtualWalletDo;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity.VirtualWalletEntity;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity.VirtualWalletTransactionEntity;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.exception.InsufficientBalanceException;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.repository.VirtualWalletRepository;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.repository.VirtualWalletTransactionRepository;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.enums.Status;
import com.coderandyli.designpattern.chapter_03_oop.section12.ddd.service.VirtualWalletService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public VirtualWalletDo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletDo walletDomain = entityConvertToDomain(walletEntity);
        return walletDomain;
    }

    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletDo walletDomain = entityConvertToDomain(walletEntity);
        walletDomain.debit(amount);
        walletRepo.updateBalance(walletId, walletDomain.getBalance());
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWalletDo walletDomain = entityConvertToDomain(walletEntity);
        walletRepo.updateBalance(walletId, walletDomain.getBalance());
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

    private VirtualWalletDo entityConvertToDomain(VirtualWalletEntity walletEntity) {
        VirtualWalletDo domain = new VirtualWalletDo();
        BeanUtils.copyProperties(walletEntity, domain);
        return domain;
    }
}
