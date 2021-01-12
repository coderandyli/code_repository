package com.coderandyli.source_analysis.map.hashMap;

import com.coderandyli.source_analysis.map.hashMap.SingleLinkedList.SingleLinkedList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-04-21
 * <p>
 * HashMap 源码分析 相关代码
 */
@Slf4j
public class Main {

    public Main() {

    }

    /**
     * 获取map的 capacity、size
     */
    @Test
    public void test04() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hollis", "hollischuang");

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));
    }

    /**
     * 单链表测试
     */
    @Test
    public void test() {
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

    /**
     * HashMap
     */
    @Test
    public void test01() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 11);
        map.put(2, 22);
        map.put(3, 33);
        map.put(4, 44);

        for (Map.Entry e : map.entrySet()) {
            log.info("{}", e.getKey());
        }
    }

    /**
     * HashMap 散列函数测试
     */
    @Test
    public void test03() {
        String key = "abc";

        int index1 = hash(key);
        System.out.println(index1);

        int capicity = 16; // 散列表大小
        int index2 = hash(key) & (capicity - 1); // HashMap 计算的最终hash值
        System.out.println("HashMap 计算的最终hash值 = " + index2);

        int i = key.hashCode();
        System.out.println(i);
        System.out.println("获取abc的hashCode = " + hashCode());
    }

    static final int hash(Object key) {
        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        int hashValue = 96354; // 字符串abc的hashCode
        return (key == null) ? 0 : (hashValue) ^ (hashValue >>> 16);
    }


    /**
     * =============================================================================
     * =========          以下 String 的 hashCode方法  示例:获取的是abc的hashCode=96354             =========
     * =============================================================================
     */

    /**
     * The value is used for character storage.
     */
    private final char value[] = {'a', 'b', 'c'};

    /**
     * Cache the hash code for the string
     */
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
