package com.coderandyli.hashMap_analysis;

import com.coderandyli.hashMap_analysis.SingleLinkedList.SingleLinkedList;
import lombok.extern.slf4j.Slf4j;
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
//        String key = "key";
//        String key = "key1";
//        String key = "key11";
//        String key = "key111";
//        String key = "key1111";
        String key = "key11111";


        int index1 = hash("");
        System.out.println(index1);

        int index2 = hash(key) & (10 - 1);
        System.out.println(index2);
    }



    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }



}
