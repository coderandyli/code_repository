package com.coderandyli.proxy.dynamicProxy;

import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/4/18 下午7:40
 */
public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello{
        @Override
        public void sayHello() {
            System.out.println("hello word");
        }
    }

    static class DynamicProxy implements InvocationHandler{

        private Object originObj;

        Object bind(Object originObj) {
            this.originObj = originObj;
            // Create proxy instance
            return Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originObj, args);
        }
    }

    public static void main(String[] args) {
//           System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//                                    sun.misc.ProxyGenerator

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // Getting the proxy object
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }

    /**
     * final class $Proxy0 extends Proxy implements IHello {
     *     private static Method m1;
     *     private static Method m3;
     *     private static Method m2;
     *     private static Method m0;
     *
     *     public $Proxy0(InvocationHandler var1) throws  {
     *         super(var1);
     *     }
     *
     *    /****************** ignore equals()、toString()、hashCode() ******************
     *
     *     public final void sayHello() throws  {
     *         try {
     *         // super.h 父类Proxy中保存的InvocationHandler示例变量， equals()、toString()、hashCode()等方法与此类似，无论动态代理的哪个方法，实际上都是在执行InvocationHandler#invoke
     *             super.h.invoke(this, m3, (Object[])null);
     *         } catch (RuntimeException | Error var2) {
     *             throw var2;
     *         } catch (Throwable var3) {
     *             throw new UndeclaredThrowableException(var3);
     *         }
     *     }
     *
     *     static {
     *         try {
     *             m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
     *             m3 = Class.forName("com.coderandyli.proxy.dynamicProxy.DynamicProxyTest$IHello").getMethod("sayHello"); //
     *             m2 = Class.forName("java.lang.Object").getMethod("toString");
     *             m0 = Class.forName("java.lang.Object").getMethod("hashCode");
     *         } catch (NoSuchMethodException var2) {
     *             throw new NoSuchMethodError(var2.getMessage());
     *         } catch (ClassNotFoundException var3) {
     *             throw new NoClassDefFoundError(var3.getMessage());
     *         }
     *     }
     * }
     */

}
