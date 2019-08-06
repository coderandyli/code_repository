package com.coderandyli.redis.demo.controller;

import com.coderandyli.redis.demo.service.HotKeySearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lizhen on 2019-07-19
 */
@Api("热词搜索")
@RestController
@RequestMapping("/hot-key")
public class HotKeySearchController {

    @Autowired
    private HotKeySearchService hotKeySearchService;

    @ApiOperation(value = "导入测试数据", notes = "", position = 1)
    @PostMapping("/add-test-data")
    public Boolean addTestData(){
        return hotKeySearchService.addTestData();
    }

    @ApiOperation(value = "搜索", notes = "", position = 1)
    @GetMapping("/search")
    public List<ZSetOperations.TypedTuple<String>> search(@RequestParam String searchKey){
        return hotKeySearchService.search(searchKey);
    }

    @ApiOperation(value = "增加权重", notes = "", position = 1)
    @PostMapping("/increment-score")
    public Double incrementScore(@RequestParam String searchKey){
        return hotKeySearchService.incrementScore(searchKey);
    }

}
