package com.coderandyli.project.controller;

import com.coderandyli.project.entity.Test;
import com.coderandyli.project.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-12-07
 */
@RestController
@RequestMapping("/import")
@Slf4j
public class ImportDataController {

    @Autowired
    private TestMapper testMapper;

    /**
     * 批量插入100万条测试数据
     *
     * @param val
     * @param source
     */
    @GetMapping("/data")
    public long importData(@RequestParam("val") int val,
                           @RequestParam("source") int source) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            List<Test> list = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                Test test = new Test();
                test.setVal(val);
                test.setSource(source);
                list.add(test);
            }
            testMapper.batchInsert(list);
            log.info("第【{}】个5000", i+1);
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
