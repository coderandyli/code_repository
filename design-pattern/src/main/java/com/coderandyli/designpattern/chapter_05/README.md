# 设计原则与思想：规范与重构

## section 29 


Transaction 是经过我抽象简化之后的一个电商系统的交易类，用来记录每笔订单交易的情况。
Transaction 类中的 execute() 函数负责执行转账操作，将钱从买家的钱包转到卖家的钱包中

### 测试用例
- 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
- buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
- 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
- 钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
- 交易正在执行着，不会被重复执行，函数直接返回 false。



## section 37
重构之后的 ID generator code 

