package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.service.LuaScriptService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lizhen on 2019-07-10
 */
@RestController
@RequestMapping("/lua")
public class LuaScriptController {

    @Autowired
    private LuaScriptService luaScriptService;

    @ApiOperation(value = "lua脚本使用", notes = "", position = 1)
    @GetMapping("/test")
    public List<String> test() {
        return luaScriptService.redisAddScriptExec();
    }
}
