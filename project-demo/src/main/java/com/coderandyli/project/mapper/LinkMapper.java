package com.coderandyli.project.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.coderandyli.project.entity.Link;
import com.coderandyli.project.enums.LinkEnum;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author Andy
 * @date 2019-07-30 13:53:44
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

    Integer isExistOriginalUrl(@Param("originalUrl") String originalUrl);

    Integer isExistShortUrl(@Param("shortUrl") String shortUrl);

    String selectShortUrlByOriginalUrl(@Param("originalUrl")String originalUrl);

    Long selectIdByType(LinkEnum custom);
}
