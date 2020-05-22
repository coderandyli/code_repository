package com.coderandyli.framework.google_guava.cache;

import com.coderandyli.framework.google_guava.cache.case_01.AbstractGuavaCache;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/26 下午3:18
 */
public class BasicDataCache <K, V> extends AbstractGuavaCache<K, V> {
    private static AbstractGuavaCache cache = new BasicDataCache();

    /**
     * 处理自动载入缓存，按实际情况载入
     * @param key
     * @return
     */
    @Override
    protected V fetchData(K key) {
        java.lang.String result = "this is a basic cache data";
        return (V)result;
    }

    public static AbstractGuavaCache getInstance() {
        return BasicDataCache.cache;
    }

}
