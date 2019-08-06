package com.coderandyli.project.controller;

import com.coderandyli.project.service.BloomFilterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-08-06
 * <p>
 * 布隆过滤器 测试
 */
@RestController
@RequestMapping("/bloom-filter")
public class BloomFilterController {

    @Autowired
    private BloomFilterService bloomFilterService;

    @ApiOperation(value = "用户id是否存在（）", notes = "", position = 1)
    @RequestMapping("/guava/idExists")
    public boolean idExists(@RequestParam("id") int id) {
        return bloomFilterService.idExists(id);
    }
}
