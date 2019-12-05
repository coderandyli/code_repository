package com.coderandyli.designpattern.chapter_03_oop.section12.fixture.repository;

import com.coderandyli.designpattern.chapter_03_oop.section12.fixture.entity.VirtualWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

/**
 * Created by lizhen on 2019-12-04
 */
public interface VirtualWalletRepository extends JpaRepository<VirtualWalletEntity, String> {

    VirtualWalletEntity getWalletEntity(Long walletId);

    BigDecimal getBalance(Long walletId);

    void updateBalance(Long walletId, BigDecimal balance);
}
