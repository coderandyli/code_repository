package com.coderandyli.project.service.impl;

import com.coderandyli.project.entity.Link;
import com.coderandyli.project.enums.LinkEnum;
import com.coderandyli.project.mapper.LinkMapper;
import com.coderandyli.project.service.RedisService;
import com.coderandyli.project.service.ShortUrlService;
import com.coderandyli.project.utils.EncodeTenToSixtyFour;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lizhen on 2019-07-29
 */
@Slf4j
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private static final String SHORT_URL_INCR_KEY = "short_url_incr_key";

    private static final String SHORT_URL_HASH_KEY = "short_url_hash";

    private static final String HOST_KEY = "http://192.168.30.12:8081/short-url/";

    @Autowired
    private LinkMapper linkMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public String generator(String originalUrl) {
        String shortUrl;

        // 使用Bloom Filter判断是否url是否已经生成过
        Boolean exists = redisService.bloomFilterExists(originalUrl);
        if (exists) {
            shortUrl = linkMapper.selectShortUrlByOriginalUrl(originalUrl);
            log.info("url已有短码");
            return spliceShortUrl(shortUrl);
        }

        Long id = redisService.increment(SHORT_URL_INCR_KEY);
        shortUrl = EncodeTenToSixtyFour.encode(id);

        Link link = new Link(id, originalUrl, shortUrl, LinkEnum.system, new Date(), new Date(), false);
        linkMapper.insert(link);
        // 插入bloom filter
        redisService.bloomFilterAdd(originalUrl);

        return spliceShortUrl(shortUrl);
    }

    @Override
    public String selectShortUrl(String originalUrl) {
        return spliceShortUrl(linkMapper.selectShortUrlByOriginalUrl(originalUrl));
    }


    /**
     * =============================================================================
     * =========          private method             =========
     * =============================================================================
     */

    /**
     * 拼接shortUrl
     *
     * @param shortUrl
     * @return
     */
    private String spliceShortUrl(String shortUrl) {
        return HOST_KEY + shortUrl;
    }

}
