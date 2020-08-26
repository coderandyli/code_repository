package com.coderandyli.source_analysis.map.linkedHashMap.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-07-02
 *
 * 基于LinkedHashMap 实现的LRU算法
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = -2379291992621808426L;

    private int maxCacheSize;

    public LRUCache(int maxCacheSize) {
        /**
         * accessOrder = true时, LinkedHashMap本身就是一个支持LRU缓存淘汰策略的缓存系统
         * true 是表示按照访问时间排序，最近访问的元素会排在队末尾，详见下方test01方法
         * @see com.coderandyli.source_analysis.map.linkedHashMap.Main
         */
        super(maxCacheSize, 0.75f, true);
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当达到预设缓存上限时删除最老元素
        return this.size() >= maxCacheSize + 1;
    }
}
