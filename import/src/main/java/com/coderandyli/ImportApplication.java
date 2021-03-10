package com.coderandyli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImportApplication {

    public static void main(String[] args) {

        // 完全禁用重新启动
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ImportApplication.class, args);
    }

}
