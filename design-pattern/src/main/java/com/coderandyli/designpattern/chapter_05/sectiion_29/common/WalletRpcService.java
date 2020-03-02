package com.coderandyli.designpattern.chapter_05.sectiion_29.common;

public class WalletRpcService {
    public Long moveMoney(Long id, Long buyerId, Long sellerId, Double amount) {
        return IdGenerator.generateId();
    }
}
