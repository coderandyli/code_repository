package com.coderandyli.framework.google_guava.cache;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/26 下午2:57
 */
public class Main {
    public static void main(String[] args) {
        boolean b1 = BasicCacheManager.initGuavaCache();
        System.out.println(BasicCacheManager.get("key"));
        BasicCacheManager.put("key", "my name is tina");

        BasicCacheManager.put("key1", "my name is tina1");
        System.out.println(BasicCacheManager.get("key"));
        System.out.println(BasicCacheManager.get("key"));
    }
}
