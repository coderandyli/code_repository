package com.coderandyli.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁的简单实现
 */
public class SpinLock {
    /**
     * 使用owner Thread 作为同步状态
     */
    private AtomicReference<Thread> ref = new AtomicReference();

    private int count = 0;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        // if re-enter, increment the count.
        if (currentThread == ref.get()) {
            ++count;
            return;
        }
        //spin
        while (ref.compareAndSet(null, currentThread)) {
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        //only the owner could do unlock;
        Thread cur = Thread.currentThread();
        if (ref.get() != cur) {
            //exception ...
        }
        ref.set(null);
    }
}
