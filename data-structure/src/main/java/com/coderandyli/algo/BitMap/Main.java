package com.coderandyli.algo.BitMap;

import sun.jvm.hotspot.debugger.Address;

import java.util.BitSet;


/**
 * Created by lizhen on 2019-08-02
 */

public class Main {

    public static void main(String[] args) {
        test01();
    }


    /**
     * 数组的排序去重
     * BitSet 底层是一个long类型的数组
     */
    public static void test01(){
        int [] array = new int [] {1,2,3,22,0,3,64};
        BitSet bitSet  = new BitSet(64 * 1);
        System.out.println(bitSet.size());   //64

        //将数组内容组bitmap
        for(int i=0;i<array.length;i++) {
            bitSet.set(array[i], true);
        }

        System.out.println(bitSet.get(22));
        System.out.println(bitSet.get(60));

        System.out.println("下面开始遍历BitSet：");
        for ( int i = 0; i < bitSet.size(); i++ ){
            System.out.println(bitSet.get(i));
        }

    }

}
