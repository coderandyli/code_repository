package com.coderandyli.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-08-17
 */

@RestController
@RequestMapping("/cors")
public class CORSController {

    @GetMapping("/test")
    public String test(){
        System.out.println("调用");
        return "CORS is success";
    }
}
