# API 监控警告模块（开闭原则、桥接模式）
监控API根据不同警告级别出发不同类型的通知
## 代码结构
 - NotificationEmergencyLevel 警告级别
 - AlertRule 警告规则
 - Alert 警告类
 - Notification 通知类
 - MsgSender 消息发送类

## AlertHandler类 开闭原则
- 原始代码
    - 不同类型的警告(error、tps等)都集中在Alert中check方法中，不符合开闭原则，代码逐渐臃肿。
- 符合开闭原则
    - 新增handler，将其实现放在各个类型的handle中。

## msgSender、notification 采用桥接模式
- 原始代码
    - 不同的消息发送逻辑都集中在Notification中，随着业务的发展，代码会变得臃肿，难以维护。
- 采用桥接模式: 不同级别的警告消息的发送消息可配置
    - 将Notification看做抽象，MsgSender看做是实现，将消息的发送逻辑从Notification抽离出来，不同消息类型在各自的Notification中实现，通过组合关系实现任意组合。