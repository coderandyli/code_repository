package com.coderandyli.RESTful.controller;

import com.coderandyli.RESTful.entity.Zoo;
import com.coderandyli.RESTful.service.ZooService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lizhen on 2019-05-02
 *
 * 1、在RESTful架构中，每个网址代表一种资源（resource），所以网址中不能有动词，
 * 只能有名词，而且所用的名词往往与数据库的表格名对应。一般来说，数据库中的表
 * 都是同种记录的"集合"（collection），所以API中的名词也应该使用复数。
 *
 * 1、HTTP五种方法，对应的CURD操作
 * GET 读取(Read)
 * POST 新建(Create)
 * PUT 更新(update)
 * PATCH 更新（updat）通常是部分更新
 * DELETE 删除
 *
 *
 * 1、版本好放入到url中
 */
@RestController
public class RESTfulController {

    @Autowired
    private ZooService zooService;


    /**
     * 获取所有动物园
     */
    @GetMapping("/v1/zoos")
    public List<Zoo> findZoos(){
        return zooService.findZoos();
    }

    /**
     * 创建一个动物园
     */
    @PostMapping("/v1/zoos")
    public boolean createZoos(@Validated @RequestBody Zoo zoo){
        return zooService.createZoos(zoo);
    }

    /**
     * 查询某个指定动物园信息
     */
    @GetMapping("/v1/zoos/{id}")
    public Zoo findZooById(@PathVariable("id") String id){
        return zooService.findZooById(id);
    }

    /**
     * 更新某个指定动物园的信息（提供该动物园的全部信息）
     */
    @PutMapping("/v1/zoos/{id}")
    public void updateZoosById(@PathVariable("id") String id, @Validated @RequestBody Zoo zoo){

    }

    /**
     * 更新某个指定动物园的信息（提供该动物园的部分信息)
     * @param id
     * @param zoo
     */
    @PatchMapping("/v1/zoos/{id}")
    public void updatePartialZoosById(@PathVariable("id") String id, @Validated @RequestBody Zoo zoo){

    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/v1/zoos/{id}")
    public void delete(@PathVariable("id") String id){

    }

    /**
     * 列出某个指定动物园的所有动物
     */
    @GetMapping("/v1/zoos/{id}/animals")
    public void getAnimals(@PathVariable("id") String id){

    }

    /**
     * 搜索
     * @param current
     * @param size
     * @param orderBy
     * @param isAsc
     */
    @GetMapping("/v1/search")
    public void test(@RequestParam("current") int current,
                     @RequestParam("current") int size,
                     @RequestParam("orderBy") String orderBy,
                     @RequestParam("isAsc") Boolean isAsc){

    }


}
