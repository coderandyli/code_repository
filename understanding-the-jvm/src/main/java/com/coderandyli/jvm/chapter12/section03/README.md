## 内存模型

### 关键字 volatile
 - 轻量型的并发锁
 - 可见性
 - 有序性 （禁止指令重排序）
 - 非原子性 
 
因此被volatile修试的变量，在并发下并不是线程安全的

#### 使用场景 
 - 运算的结果并不依赖当前值，或者能够确保只有单一的线程修改变量的值 
 - 变量不需要与其他的状态变量共同参与不变约束
 
 ```
    // 因此，被volatile修饰的变量特别适合作为一个状态标识量
     private volatile boolean initialized = false;
 
     public void init(){
         // ... 耗时操作 ...
         initialized = true;
     }
 
     public void doWork(){
         while (initialized){
             // do something
         }
     }
```
 
  