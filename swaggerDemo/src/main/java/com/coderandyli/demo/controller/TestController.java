package com.coderandyli.demo.controller;

import com.coderandyli.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by lizhen on 2018-12-16
 */

@Api("测试")
@RequestMapping("/api/test")
@RestController
public class TestController {

    @ApiOperation(value = "根据id获取详情", notes = "接口更多说明")
    @GetMapping("/{id}")
    public String test1(@ApiParam("用户id") @PathVariable("id") String id) {
        User user = null;
        user.getId();
        return id;
    }

    @ApiIgnore//使用该注解忽略这个API
    @ApiOperation(value = "test2", notes = "test2接口更多说明")
    @PostMapping("/{id}")
    public void test2() {
    }

    @ApiOperation(value = "删除", notes = "test3接口更多说明")
    @DeleteMapping("/{id}")
    public void test3() {
    }
}
