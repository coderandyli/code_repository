## EventBus(事件总线)实现逻辑分析（仿Google Guava EventBus）

- EventBus: 对外暴露所有可调用接口
    - register() 注册观察者
    - unregister() 移除观察者
    - post() 向观察者发送消息
    
- AsyncEventBus：继承自EventBus

- @Subscribe注解，标注观察者哪些方法可以接收消息。

- ObserverMethod 表示@Subscribe的方法。
  
- ObserverRegister 观察者注册