package com.coderandyli.designpattern.practices.eventBus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/17 上午9:55
 */
public class EventBus {

    private Executor executor;
    private ObserverRegister register = new ObserverRegister();

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    /**
     * register observer
     *
     * @param observer
     */
    public void register(Object observer) {
        register.register(observer);

    }

    /**
     * remove observer
     *
     * @param observer
     */
    public void unregister(Object observer) {
        register.unregister(observer);
    }

    /**
     * send event to observer
     *
     * @param event
     */
    public void post(Object event) {
        List<ObserverMethod> observerMethods = register.getMatchedObserverMethods(event);
        for (ObserverMethod observerMethod : observerMethods) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerMethod.execute(event);
                }
            });
        }

    }
}
