package com.coderandyli.project.service.impl;

import com.coderandyli.project.entity.Link;
import com.coderandyli.project.enums.LinkEnum;
import com.coderandyli.project.mapper.LinkMapper;
import com.coderandyli.project.service.RedisService;
import com.coderandyli.project.service.ShortUrlService;
import com.coderandyli.project.utils.EncodeTenToSixtyFour;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lizhen on 2019-07-29
 */
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
    public String generator(String originalUrl, String customUrl) {
        String shortUrl;
        boolean isSystemUrl = StringUtils.isBlank(customUrl);

        Integer integer = linkMapper.isExistOriginalUrl(originalUrl);
        if (integer != null && integer == 1) { // 已存在
            shortUrl = linkMapper.selectShortUrlByOriginalUrl(originalUrl);
            return spliceShortUrl(shortUrl);
        }

        if (isSystemUrl) { // 系统生成
            Long id = redisService.increment(SHORT_URL_INCR_KEY);
            shortUrl = EncodeTenToSixtyFour.encode(id);

            // when shortUrl exist
            Integer existShortUrl = linkMapper.isExistShortUrl(shortUrl);
            if (existShortUrl != null && existShortUrl == 1) {
                Long customId = linkMapper.selectIdByType(LinkEnum.custom);
                shortUrl = EncodeTenToSixtyFour.encode(customId);

                Link link = new Link();
                link.setId(customId);
                link.setIdUsed(true);
                linkMapper.updateById(link);
            }

            Link link = new Link(id, originalUrl, shortUrl, LinkEnum.system, new Date(), new Date(), false);
            linkMapper.insert(link);

        } else { // 自定义短url
            //todo

        }
        return null;
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
