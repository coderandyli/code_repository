package com.coderandyli.designpattern.chapter_08.section_57.case_02;


import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 表示@Subscribe注解的方法
 */
public class ObserverAction {
    /**
     * 观察者类
     */
    private Object target;
    /**
     * 方法
     */
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    /**
     * 通过反射执行方法
     * @param event event是method方法的参数
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
