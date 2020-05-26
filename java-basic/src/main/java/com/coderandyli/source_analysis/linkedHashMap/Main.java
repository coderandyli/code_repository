package com.coderandyli.source_analysis.linkedHashMap;

import com.coderandyli.source_analysis.linkedHashMap.LRU.LRUCache;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-07-02
 */
public class Main {

    @Test
    public void test01(){
        // 10 是初始大小，0.75 是装载因子，true 是表示按照访问时间排序 最近访问的元素会排在队末尾
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(5, 26); // 删除原有的key = 5数据,并将新的数据放到链表的尾部
        m.get(3); // 将访问的数据移动到链表的尾部

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    /**
     * HashMap
     */
    @Test
    public void test02(){
        Map<Integer, Integer> m = new HashMap<>();
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry e: m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    /**
     * LRUCache测试
     */
    @Test
    public void test03(){

        LRUCache<String, String> cache = new LRUCache<>(3);

        cache.put("k1", "v1");

        System.out.println("test1:"+cache);

        cache.put("k2", "v2");

        System.out.println("test2:"+cache);

        cache.put("k3", "v3");

        System.out.println("test3:"+cache);

        cache.put("k4", "v4");

        System.out.println("test4:"+cache);

        //因为我们在后再对象时，accessOrder设置为true，访问一次 k2，k2对应的元素就会排在队尾部，被看做最新元素
        cache.get("k2");

        System.out.println("test5:"+cache);


        Map<String,String> multiKV = new HashMap<>();

        multiKV.put("k5", "k5");

        multiKV.put("k6", "k6");

        cache.putAll(multiKV);

        System.out.println("test6:"+cache);


    }

}
