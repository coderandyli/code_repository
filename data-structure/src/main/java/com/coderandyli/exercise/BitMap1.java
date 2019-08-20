package com.coderandyli.exercise;

/**
 * Created by lizhen on 2019-08-07
 *
 *  基于int[]实现的BitMap 练习
 *
 */
public class BitMap1 {

    private static final int ADDRESS_BITS_PER_WORD = 5;
    private static final int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD; // 32
    private static final int BIT_INDEX_MASK = BITS_PER_WORD - 1; // 31

    private int length;
    private int[] words;

    public static int getWordIndex(int index) {
        return index >> ADDRESS_BITS_PER_WORD;
    }

    /**
     * 构造方法
     * 初始化 length以及bitMap大小
     */
    public BitMap1(int length) {
        this.length = length;
        this.words = new int[getWordIndex(length) + (length & BIT_INDEX_MASK) > 0 ? 1 : 0];
    }

    public void set(int bitIndex) {
        // 计算wordIndex
        int wordIndex = getWordIndex(bitIndex);
        // 获取word
        int word = words[wordIndex];
        // 计算偏移量
        int offset = bitIndex & BIT_INDEX_MASK;
        words[wordIndex] = word | (0x01 << offset);
    }

    public int get(int bitIndex) {
        // 计算wordIndex
        int wordIndex = getWordIndex(bitIndex);
        // 获取word
        int word = words[wordIndex];
        // 计算偏移量
        int offset = bitIndex & BIT_INDEX_MASK;

        return word >> offset & 0x01;
    }

    public static void main(String args[]) {
        BitMap1 bitMap1 = new BitMap1(10);
        bitMap1.set(1);
        bitMap1.set(2);
        bitMap1.set(3);

        System.out.println(bitMap1.get(1) + " " + bitMap1.get(2) + " " + bitMap1.get(3) + " " + bitMap1.get(4) + " ");
    }


}
