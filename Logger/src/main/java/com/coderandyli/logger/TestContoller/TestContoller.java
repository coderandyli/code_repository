package com.coderandyli.logger.TestContoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by lizhen on 2019-01-12
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestContoller {

    @GetMapping("/consoleLog")
    public void consoleLog(){
        log.info("console info");
        log.debug("console debug");
        log.error("console error");

        Objects.requireNonNull(null, "the value cannot be null");
    }
}
