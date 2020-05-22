package com.coderandyli.source_analysis.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/8 下午6:39
 */
public class Main {

    public static void main(String[] args) {
         testGrow();
    }


    /**
     * 测试ArrayList方法中grow()
     *  考虑了int类型的溢出
     */
    public static void testGrow() {

        int oldCapacity = Integer.MAX_VALUE - 16; // 假设 oldCapacity 很大
        System.out.println(oldCapacity);
        int minCapacity = Integer.MAX_VALUE - 15;
        int maxSize = Integer.MAX_VALUE - 8;

        // >> 1 等价于 /2
        // 发生溢出
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);

        // 防止溢出
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - maxSize > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        System.out.println(newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > Integer.MAX_VALUE - 8) ?
                Integer.MAX_VALUE :
                Integer.MAX_VALUE - 8;
    }
}
