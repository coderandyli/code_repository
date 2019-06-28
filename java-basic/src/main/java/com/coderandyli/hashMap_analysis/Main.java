package com.coderandyli.hashMap_analysis;

import com.coderandyli.hashMap_analysis.SingleLinkedList.SingleLinkedList;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-04-21
 *
 * HashMap 源码分析 相关代码
 */
@Slf4j
public class Main {

    public Main() {
    }

    /**
     * 单链表测试
     */
    @Test
    public void test(){
        SingleLinkedList linkList = new SingleLinkedList();
        linkList.addFirstNode(20);
        linkList.addFirstNode(21);
        linkList.addFirstNode(19);
        linkList.add(1, 22); //print19,22,21,20
        linkList.add(2, 23); //print19,22,23,21,20
        linkList.add(3, 99); //print19,22,23,99,21,20

        linkList.add(10, 100); //print19,22,23,99,21,20
        //调用此方法会print 19,22,23,99,21,20
        linkList.displayAllNodes();
    }

    @Test
    public void test01(){
        Map<String, String> map = new HashMap<>();
        String put = map.put("name", "andy");
    }

    /**
     * HashMap 散列函数测试
     */
    @Test
    public void test03(){
        String key = "abc";

        int index1 = hash(key);
        System.out.println(index1);

        int capicity = 16; // 散列表大小
        int index2 = hash(key) & (capicity - 1); // HashMap 计算的最终hash值
        System.out.println("HashMap 计算的最终hash值 = " +index2);

        int i = key.hashCode();
        System.out.println(i);
        System.out.println("获取abc的hashCode = "+hashCode());
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        return (key == null) ? 0 : (96354) ^ (96354 >>> 16);
    }
    
    
    /**
     * =============================================================================
     * =========          以下 String 的 hashCode方法             =========
     * =============================================================================
     */

    /** The value is used for character storage. */
    private final char value[] = {'a','b', 'c'};

    /** Cache the hash code for the string */
    private int hash; // Default to 0

    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
}
