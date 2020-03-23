package com.coderandyli.designpattern.chapter_08.section_57.case_02;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;


public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    /**
     * 向观察者发送消息
     * @param event
     */
    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}