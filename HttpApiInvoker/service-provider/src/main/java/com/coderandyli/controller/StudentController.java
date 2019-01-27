package com.coderandyli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2019-01-27
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/list")
    public List<Map<String, Object>> test(){
        List<Map<String, Object>>  list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("userName", "andy"+ i);
            map.put("age", 18 + i);
            list.add(map);
        }
        return list;
    }
}
