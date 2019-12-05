package com.coderandyli.designpattern.chapter_03_oop.section12.fixture.repository;

import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity.VirtualWalletTransactionEntity;
import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lizhen on 2019-12-04
 */
public interface VirtualWalletTransactionRepository extends JpaRepository<VirtualWalletTransactionEntity, Long> {
    void updateStatus(Long transactionId, Status status);

    Long saveTransaction(VirtualWalletTransactionEntity transactionEntity);
}
