package com.coderandyli.lock;

/**
 * 可重入锁代码演示
 */
public class ReentrantLockTest {


    /* synchronized可重入性代码测试 */
    /**
     * 可重入锁：是指在同一个线程在外层方法获取锁的时候，再进入该线程的内层方法会自动获取锁（前提锁对象得是同一个对象或者class）
     * - 如果synchronized不具有可重入性，以下代码就会造成死锁（当前线程调用doOthers时，需要将执行doSomething时获取的的当前对象的锁释放掉，
     *   实际上当前对象锁已被当前线程持有，且无法释放，造成死锁）
     */
    public synchronized void doSomething(){
        System.out.println("方法1执行...");
        doOthers();
    }
    public synchronized void doOthers(){
        System.out.println("方法2执行...");
    }

}
