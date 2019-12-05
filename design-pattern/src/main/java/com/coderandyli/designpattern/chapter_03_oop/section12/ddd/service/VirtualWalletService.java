package com.coderandyli.designpattern.chapter_03_oop.section12.ddd.service;

import com.coderandyli.designpattern.chapter_03_oop.section12.ddd.domain.VirtualWalletDo;

/**
 * Created by lizhen on 2019-12-04
 */
public interface VirtualWalletService {

    VirtualWalletDo getVirtualWallet(Long walletId);
}
