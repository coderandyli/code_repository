package com.coderandyli.redis.demo.service;

/**
 * Created by lizhen on 2019-07-29
 */
public interface ShortUrlService {

    String generator(String originalUrl, String customUrl);
}
