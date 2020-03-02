package com.coderandyli.designpattern.chapter_05.sectiion_29;
import com.coderandyli.designpattern.chapter_05.sectiion_29.common.STATUS;

import javax.transaction.InvalidTransactionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 测试用例
 * - 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
 * - buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
 * - 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
 * - 钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
 * - 交易正在执行着，不会被重复执行，函数直接返回 false。
 */

public class Test {

    public static void main(String[] args) throws InvalidTransactionException {
        new Test().testExecute01();
    }

    /**
     * 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，
     * 交易状态设置为 EXECUTED，函数返回 true。
     * @throws InvalidTransactionException
     */
    private void testExecute01() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 3456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    /**
     * buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
     */
    public void testExecute02() throws InvalidTransactionException {
        Long buyerId = null;
        Long sellerId = null;
        Long productId = 345L;
        Long orderId = 3456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
    }

    /**
     * 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。
     */
    void testExecute03() throws InvalidTransactionException {
        Long buyerId = null;
        Long sellerId = null;
        Long productId = 345L;
        Long orderId = 3456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXPIRED, transaction.getStatus());

    }

}
