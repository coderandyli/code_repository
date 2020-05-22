package com.coderandyli.framework.google_guava.cache;

import com.coderandyli.framework.google_guava.cache.case_01.DefaultGuavaCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/26 下午3:17
 */
public class BasicCacheManager extends DefaultGuavaCacheManager {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(BasicCacheManager.class);

    /**
     * 初始化缓存容器
     */
    public static boolean initGuavaCache() {
        try {
            cacheWrapper = BasicDataCache.getInstance();
            if (cacheWrapper != null) {
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Failed to init Guava cache;", e);
        }
        return false;
    }
}
