package com.coderandyli.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //启用Spring cache
public class SpringCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheDemoApplication.class, args);
	}

}
