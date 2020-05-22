package com.coderandyli.algo.BitMap;

import sun.jvm.hotspot.debugger.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;


/**
 * Created by lizhen on 2019-08-02
 */
public class BitSetTest {

    public static void main(String[] args) {
        // test01();
        containChars("1234567890qwertyuiop");

        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        bitSet.set(4);
        byte[] bytes = bitSet2ByteArray(bitSet);
        // System.out.println(Arrays.toString(bytes));


        BitSet bitSet1 = byteArray2BitSet(bytes);
        for (int i = 0; i < bitSet.size(); i++) {
            System.out.println(bitSet.get(i));
        }
    }


    /**
     * 将ByteArray对象转化为BitSet
     *
     * @param bytes
     * @return
     */
    public static BitSet byteArray2BitSet(byte[] bytes) {
        BitSet bitSet = new BitSet(bytes.length * 8);
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 7; j >= 0; j--) {
                bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1 ? true
                        : false);
            }
        }
        return bitSet;
    }

    /**
     * 将BitSet对象转化为ByteArray
     *
     * @param bitSet
     * @return
     */
    public static byte[] bitSet2ByteArray(BitSet bitSet) {
        byte[] bytes = new byte[bitSet.size() / 8];
        for (int i = 0; i < bitSet.size(); i++) {
            int index = i / 8;
            int offset = 7 - i % 8;
            bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
        }
        return bytes;
    }

    /**
     * 求一个字符串包含的char
     */
    public static void containChars(String str) {
        BitSet used = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            used.set(str.charAt(i)); // set bit for char
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = used.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (used.get(i)) {
                sb.append((char) i);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


    /**
     * 数组的排序去重
     * BitSet 底层是一个long类型的数组
     */
    public static void sortArray() {
        int[] array = new int[]{1, 2, 2, 3, 22, 0, 3, 64};
        BitSet bitSet = new BitSet(64 * 1);
        System.out.println(bitSet.size());   //64

        //将数组内容组bitmap
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }

        System.out.println(bitSet.get(22));
        System.out.println(bitSet.get(60));

        System.out.println("下面开始遍历BitSet：");
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < bitSet.size(); i++) {
            boolean b = bitSet.get(i);
            if (b) {
                results.add(i);
            }
        }

        results.stream().forEach(System.out::println);
    }

}
