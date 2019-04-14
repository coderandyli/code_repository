package com.coderandyli.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-04-14
 */
@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    @MyAnnotation(value = "value test")
    @GetMapping("/test")
    public String test(){
        return "this is annotation test";
    }
}
