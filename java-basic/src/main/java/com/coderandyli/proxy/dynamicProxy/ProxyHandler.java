package com.coderandyli.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lizhen on 2019-11-11
 *
 * JDK 动态代理
 */
public class ProxyHandler implements InvocationHandler {

    // 目标对象
    private Object targetObj;

    /**
     * 绑定委托对象，并返回代理对象
     *
     * @param targetObj
     * @return
     */
    public Object bind(Object targetObj) {
        this.targetObj = targetObj;
        // 绑定该类实现的所有接口，生成代理类
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
                targetObj.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method exec before....");
        Object result = method.invoke(targetObj, args);
        System.out.println("method exec after....");
        return result;
    }
}
