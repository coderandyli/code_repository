package com.coderandyli.project.controller;

import com.coderandyli.project.mapper.LinkMapper;
import com.coderandyli.project.service.ShortUrlService;
import com.coderandyli.project.utils.ValidateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lizhen on 2019-07-29
 *
 * 短链接的实现
 */
@RestController
@RequestMapping("/short-url")
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    private LinkMapper linkMapper;


    @ApiOperation(value = "生成短链接", notes = "", position = 1)
    @GetMapping("/generator")
    public String generator(@RequestParam("originalUrl") String originalUrl, @RequestParam("customUrl") String customUrl) {
        if (!ValidateUtils.checkURL(originalUrl)){
            //todo 网址不合法
            return "网址不合法, 请重新输入";
        }

        return shortUrlService.generator(originalUrl, customUrl);
    }

    @GetMapping("/{shortUrl}")
    public void test(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) {
        response.addHeader("location", shortUrlService.selectShortUrl(shortUrl));
        response.setStatus(302);
    }


}
