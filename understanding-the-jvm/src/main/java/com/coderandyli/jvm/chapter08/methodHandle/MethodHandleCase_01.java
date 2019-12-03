package com.coderandyli.jvm.chapter08.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by lizhen on 2019-12-02
 *
 * invokedynamic指令使用场景
 * 控制方法分派逻辑
 *
 * 预期结果
 *      I am grandFather
 *
 * 实际结果
 *      I am father
 * 实验结果没有达到预期，不清楚什么原因
 *
 *
 */
public class MethodHandleCase_01 {
    private static final String METHOD_NAME_THINKING = "thinking";

    class GrandFather {
        void thinking() {
            System.out.println("I am grandFather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("I am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {
            // 不修改其他代码实现调用，GrandFather中thinking
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        ((new MethodHandleCase_01()).new Son()).thinking();
    }

}
