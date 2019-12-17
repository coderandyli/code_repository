package com.coderandyli.designpattern.chapter_03_oop.section12.mvc.service;

import com.coderandyli.designpattern.chapter_03_oop.section12.mvc.bo.VirtualWalletBo;

/**
 * Created by lizhen on 2019-12-04
 */
public interface VirtualWalletService {

    VirtualWalletBo getVirtualWallet(Long walletId);
}
