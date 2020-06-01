package com.coderandyli.designpattern.practices.eventBus.case_01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObserverMethod {
    /**
     * 观察者类
     */
    private Object target;
    /**
     * 方法
     */
    private Method method;

    public ObserverMethod(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    /**
     * 执行
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ObserverMethod{" +
                "target=" + target +
                ", method=" + method +
                '}';
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }
}
