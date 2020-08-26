package com.coderandyli.source_analysis.map.hashMap;

/**
 * Created by lizhen on 2019-07-01
 * HashMap hash方法分析
 */
public class HashAnalysis {


    public static void main(String args[]) {

        /**
         * 1、hashcode本身是个32位整型值，在系统中，这个值对于不同的对象必须保证唯一
         */
        // hash = key.hashCode()

        /**
         * 2、先位移运算，然后再与自己做与或运算
         *      将高16位位移到低16位，使结果具有"高位和地位"的性质
         */
        // hashcode ^ (hashcode >>> 16)

        /**
         * 3、计算出在数组的位置
         *      hash表当前的容量-1 与 计算结果进行位与运算
         * 为什么当前容量-1 ？
         *     HashMap 中容量capacity是2的整数倍，
         *     所以 A % capacity = A & (capacity - 1)成立
         *     即 这里本质上是使用了「除留余数法」
         *
         */
        // int index = hash(key) & (capacity - 1)
    }

    /**
     * =============================================================================
     * =========          HashMap 源码             =========
     * =============================================================================
     */
    /*
    // 1. hash值的计算，源码如下：
    static final int hash(Object key) {
        int hash;
        return key == null ? 0 : (hash = key.hashCode()) ^ hash >>> 16;
    }

    //2. 在插入或查找的时候，计算Key被映射到桶的位置：
    int index = hash(key) & (capacity - 1)
    */


}
