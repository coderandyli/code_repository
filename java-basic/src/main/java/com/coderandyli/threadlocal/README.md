# ThreadLocal

- ThreadLocal<T>其实是与线程绑定的一个变量
- ThreadLocal则用于线程间的数据隔离
- 而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享


# Reference 
(ThreadLocal使用场景分析)[https://www.jianshu.com/p/f956857a8304]