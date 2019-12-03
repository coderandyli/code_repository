package com.coderandyli.jvm.chapter08.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by lizhen on 2019-12-02
 * <p>
 * MethodHandle 的基本用法
 */
public class MethodHandleTest {
    private final static String METHOD_NAME_PRINTLN = "println";

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    /**
     *  模拟了invokevirtual指令的执行过程
     * @param reveiver
     * @return
     * @throws Throwable
     */
    private static MethodHandle getPrinlnMH(Object reveiver) throws Throwable {
        /* MethodType 代表"方法类型"，包含了方法的 返回值(methodType()的第一个参数) 和 入参（methodType()第二个及以后的参数）*/
        MethodType mt = MethodType.methodType(void.class, String.class);

        /**
         * lookup() 方法来自MethodHandles.lookup, 在指定类中查找符合给定的方法名称、方法类型、并符合调用权限的方法句柄
         * 因为这里调用的是一个虚方法，按照java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即是this指向的对象，
         * 这个参数以前是放在参数列表中进行传递的，而现在提供bindTo方法来完成这件事情
         */
        return lookup().findVirtual(reveiver.getClass(), METHOD_NAME_PRINTLN, mt).bindTo(reveiver);
    }

    public static void main(String args[]) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrinlnMH(obj).invokeExact("hello MethodHandle");
    }
}
