# API 监控警告模块
监控API根据不同警告级别出发不同类型的通知
## 代码结构
 - NotificationEmergencyLevel 警告级别
 - AlertRule 警告规则
 - Alert 警告类
 - Notification 通知类
 - MsgSender 消息发送类

## AlertHandler类
- 符合开闭原则，新增需求可以新增一个handler满足

## msgSender、notification 
- 采用桥接模式
 
 
 