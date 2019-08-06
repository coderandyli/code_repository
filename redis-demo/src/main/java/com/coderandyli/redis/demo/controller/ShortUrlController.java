package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lizhen on 2019-07-29
 */
@RestController
@RequestMapping("/short-url")
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;


    @GetMapping("/generator")
    public String generator(@RequestParam("originalUrl") String originalUrl, @RequestParam("customUrl") String customUrl) {
        return shortUrlService.generator(originalUrl, customUrl);
    }

    @GetMapping("/{shortUrl}")
    public String test(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) {

        response.addHeader("location", "https://www.baidu.com");
        response.setStatus(302);
        return "2345";
    }


}
