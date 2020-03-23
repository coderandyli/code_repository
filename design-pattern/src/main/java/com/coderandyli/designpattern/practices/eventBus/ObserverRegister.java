package com.coderandyli.designpattern.practices.eventBus;


import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/17 上午9:58
 */
public class ObserverRegister {
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverMethod>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        List<ObserverMethod> subscribeMethods = getAnnotationMethods(observer);

        for (ObserverMethod observerMethod : subscribeMethods) {
            Method method = observerMethod.getMethod();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> parameterType = parameterTypes[0];
            CopyOnWriteArraySet<ObserverMethod> observerMethods = registry.get(parameterType);
            if (observerMethods == null) {
                observerMethods = new CopyOnWriteArraySet<>();
            }
            observerMethods.add(observerMethod);
            registry.putIfAbsent(parameterType, observerMethods);
        }
    }

    public void unregister(Object observer) {

    }

    /**
     * 获取匹配的 ObserverMethod
     * @param event
     * @return
     */
    public List<ObserverMethod> getMatchedObserverMethods(Object event) {
        List<ObserverMethod> matchMathods = new ArrayList<>();
        Class<?> eventClass = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverMethod>> entry : registry.entrySet()) {
            Class<?> key = entry.getKey();
            CopyOnWriteArraySet<ObserverMethod> mathods = entry.getValue();
            if (key.isAssignableFrom(eventClass)) {
                matchMathods.addAll(mathods);
            }
        }
        return matchMathods;
    }

    /**
     * 获取observer下所有@Subscribe标识的方法
     *
     * @param observer
     */
    @VisibleForTesting
    protected List<ObserverMethod> getAnnotationMethods(Object observer) {
        List<ObserverMethod> observerMethods = new ArrayList<>();
        for (Method method : observer.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                observerMethods.add(new ObserverMethod(observer, method));
            }
        }
        return observerMethods;
    }
}
