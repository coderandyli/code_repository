package com.coderandyli.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by lizhen on 2019-01-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
// 使用注解简化
@Slf4j(topic = "logger test")
public class LoggerTest {

    // private final Logger logger = LoggerFactory.getLogger("logger test");
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
    }

    @Test
    public void test2(){
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
    }



}
