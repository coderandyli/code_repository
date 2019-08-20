package com.coderandyli.algo.BitMap;

/**
 * Created by lizhen on 2019-08-05
 * 基于int[] 实现的BitMap
 *
 *
 * 0x01
 *   - 0x 表示16进制
 *
 * 问题
 *  1、涉及到位运算为什么会使用16进制呢?
 *      1.1、 涉及到位运算必然要使用二进制， 16进制比较转换成二进制（1个16进制可以表示4个二进制），同时可以很直观的看到结果
 *
 *  https://blog.csdn.net/zhongdong00/article/details/83049053
 *
 */
public class BitMap {

    private final static int ADDRESS_BITS_PER_WORD = 5;  // 5
    private final static int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD; //  32
    private final static int BIT_INDEX_MASK = BITS_PER_WORD - 1; // 31

    private static int getWordIndex(int bitIndex) {
        return bitIndex >> ADDRESS_BITS_PER_WORD;
    }

    private int length;
    public int[] words;

    public BitMap(int length) {
        if (length < 0) {
            System.out.println("长度不合法");
            return;
        }

        this.length = length;
        this.words = new int[(getWordIndex(length)) + (length & BIT_INDEX_MASK) > 0 ? 1 : 0];
    }

    /**
     * @param bitIndex
     * @param value
     */
    public void set(int bitIndex, boolean value) {
        if (value) {
            // 获取wordIndex
            int wordIndex = getWordIndex(bitIndex);
            int word = words[wordIndex];
            // 获取在word中偏移量
            int offset = bitIndex & BIT_INDEX_MASK;
            // 赋值
            words[wordIndex] = word | (0x01 << offset);
        } else {
            // todo 未实现
        }
    }

    public int getBit(int bitIndex) {
        int wordIndex = getWordIndex(bitIndex);
        int word = words[wordIndex];
        // 获取在word中偏移量
        int offset = bitIndex & BIT_INDEX_MASK;
        return word >> offset & 0x01;
    }

    public static void main(String args[]) {

        BitMap bitMap = new BitMap(100);
        bitMap.set(1, true);
        bitMap.set(2, true);
        bitMap.set(3, true);

        System.out.println(bitMap.getBit(1));
        System.out.println(bitMap.getBit(2));
        System.out.println(bitMap.getBit(3));
        System.out.println(bitMap.getBit(4));

        int[] words = bitMap.words;
        for (int word : words) {
            System.out.println(word);
        }
    }


}
