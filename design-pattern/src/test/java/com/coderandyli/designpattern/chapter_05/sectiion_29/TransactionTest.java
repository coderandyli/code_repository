package com.coderandyli.designpattern.chapter_05.sectiion_29;

import com.coderandyli.designpattern.chapter_05.sectiion_29.common.STATUS;
import com.coderandyli.designpattern.chapter_05.sectiion_29.common.WalletRpcService;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.InvalidTransactionException;


/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/7 下午1:44
 * Transaction类 execute方法测试用例
 * <p>
 * - 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
 * - buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
 * - 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。
 * - 交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
 * - 钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
 * - 交易正在执行着，不会被重复执行，函数直接返回 false。
 */
public class TransactionTest {

    /**
     * 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，
     * 交易状态设置为 EXECUTED，函数返回 true。
     *
     * @throws InvalidTransactionException
     */
    @Test
    public void testExecute_success() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 3456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        transaction.setWalletRpcService(new WalletRpcService());
        boolean executedResult = transaction.execute();
        Assert.assertTrue(executedResult);
        Assert.assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    /**
     * buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
     */
    @Test(expected = InvalidTransactionException.class)
    public void testExecute_throwException() throws InvalidTransactionException {
        Long buyerId = null;
        Long sellerId = null;
        Long productId = 345L;
        Long orderId = 3456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
        boolean executedResult = transaction.execute();
        Assert.assertTrue(executedResult);
    }

    /**
     * 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。
     */
    @Test
    public void testExecute_with_TransactionIsExpired() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
//        transaction.setCreatedTimestamp(System.currentTimestamp() - 14days);
        boolean actualResult = transaction.execute();
        Assert.assertFalse(actualResult);
        Assert.assertEquals(STATUS.EXPIRED, transaction.getStatus());
    }

}