package com.coderandyli.project.controller.redis;

import com.coderandyli.project.service.RedisBitMapService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-08-04
 *
 * 基于Redis BitMap(位图)签到功能的简单实现
 *
 */
@RestController
@RequestMapping("/redis/bitmap/sign-in")
public class RedisBitMapController {

    @Autowired
    private RedisBitMapService redisBitMapService;

    @ApiOperation(value = "签到", notes = "")
    @PostMapping("")
    public Boolean signIn() {
        return redisBitMapService.signIn();
    }

    @ApiOperation(value = "获取签到信息", notes = "")
    @GetMapping("")
    public String getSignIn() {
        return redisBitMapService.getSignIn();
    }
}
