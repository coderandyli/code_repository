package com.coderandyli.slf4jdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @PostMapping("/print")
    public void print(){
        log.debug("print debug");
        log.info("print info");
        log.warn("print warn");
        log.error("print error");
    }
}
