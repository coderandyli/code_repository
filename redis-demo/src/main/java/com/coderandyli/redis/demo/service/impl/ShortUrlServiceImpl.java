package com.coderandyli.redis.demo.service.impl;

import com.coderandyli.redis.demo.service.RedisService;
import com.coderandyli.redis.demo.service.ShortUrlService;
import com.coderandyli.redis.demo.utils.EncodeTenToSixtyFour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhen on 2019-07-29
 */
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private static final String SHORT_URL_INCR_KEY = "short_url_incr_key";

    private static final String SHORT_URL_HASH_KEY = "short_url_hash";

    private static final String HOST_KEY = "http://localhost:8081/short-url";


    @Autowired
    private RedisService redisService;

    @Override
    public String generator(String originalUrl, String customUrl) {
        String shortUrl;


        Boolean isExists = redisService.hHasKey(SHORT_URL_HASH_KEY, originalUrl);
        if (!isExists) {
            shortUrl = EncodeTenToSixtyFour.encode(redisService.increment(SHORT_URL_INCR_KEY));
            redisService.hmSet(SHORT_URL_HASH_KEY, originalUrl, shortUrl);
        } else {
            shortUrl = redisService.hmGet(SHORT_URL_HASH_KEY, originalUrl);
        }

        return HOST_KEY + shortUrl;
    }

    public String selectShortUrl(String originalUrl) {
        return redisService.hmGet(SHORT_URL_HASH_KEY, originalUrl);
    }
}
