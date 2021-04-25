package com.coderandyli.lock.clh;

import com.coderandyli.lock.aqs.MyLockBaseAqs;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: lizhenzhen
 * @date: 2021-04-25 16:49
 *
 * CLH队列锁：是一个自旋锁，能确保无饥饿性，提供先来先服务的公平性。同时它也是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，它不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋
 * > 这个算法很妙的点在于，在一个CAS操作帮助下，所有等待获取锁的线程之下的节点轻松且正确地构建成了全局队列。等待中的线程正如队列中的节点依次获取锁。
 **/
public class CLHLockExample {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private static class QNode {
        private int count;
        volatile boolean locked;

        public QNode(){
            count = counter.getAndIncrement();
        }

        @Override
        public String toString() {
            return "QNode{" +
                    "count=" + count +
                    ", locked=" + locked +
                    '}';
        }
    }

    private interface Lock{
        void lock();
        void unlock();
    }

    private static class CLHLock implements Lock{
        // 尾巴，所有线程共有，所有线程进来后，将自己设置为tail
        private AtomicReference<QNode> tail;
        // 前驱节点，每个线程独有一个
        private ThreadLocal<QNode> myPred;
        // 当前节点，表示自己，每个线程独有一个
        private ThreadLocal<QNode> myNode;

        public CLHLock() {
            // 初始状态，tail指向一个新node(head)节点。
            this.tail = new AtomicReference<>(new QNode());
            this.myNode = ThreadLocal.withInitial(QNode::new);
            this.myPred = new ThreadLocal<>();
        }

        private void peekNodeInfo(String text) {
            System.out.println(Thread.currentThread().getName()
                    + " " + text + ". " +
                    // "tail=" + tail.get() + ", " +
                    "myNode" + myNode.get() + ", " +
                    "myPred" + myPred.get());

        }

        @Override
        public void lock() {
            // 获取当前线程的代表节点
            QNode node = myNode.get();
            // 将其状态设置为true, 表示获取锁
            node.locked = true;
            // 将自己放在队列的尾部，并返回以前的值，第一次将获取构造函数中的new QNode();
            QNode pred = tail.getAndSet(node);
            // 将旧的节点放入前驱节点
            myPred.set(pred);
            // 等待前驱节点的locked变为false（这是一个自旋等待的过程）
            // 前驱节点设置为false，表示前驱节点已经释放了锁。此时当前节点持有锁
            while (pred.locked){
            }
            peekNodeInfo("acquire lock sucess.");
        }

        @Override
        public void unlock() {
            // unlock，获取自己的node，把自己的locked设置为false
            QNode node = myNode.get();
            node.locked = false;
            // 将当前node指向前驱node, 这样操作等于把当前node从链表头部删除(并不是被JVM回收)
            // lock方法中再也拿不到当前Node的引用了，当前线程若要在unlock之后再次拿锁需要重新排队
            // 但是每个线程自己都维护两个QNode, 一个在释放锁的时候把当前node置为前驱node
            // 另一个在lock方法的时候重新获取尾node作为前驱node
            // 如果所有的任务都是由固定数量的线程池执行的话，你会看到所有的QNode的使用会形成一个环形链表（实际不是）
            myNode.set(myPred.get());
        }
    }

    static int cnt = 0;
    public static void main(String[] args) {
        Lock myLock = new CLHLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 加锁
                myLock.lock();

                int n = 10000;
                while (n > 0) {
                    cnt++;
                    n--;
                }

                // 释放锁
                myLock.unlock();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try {
            //等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cnt);
    }

}
