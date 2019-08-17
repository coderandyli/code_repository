package com.coderandyli.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lizhen on 2019-08-17
 * <p>
 * 跨域问题
 */
@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**") // 配置可以被跨域的路径
                        .allowedOrigins("*")           // 配置请求域名允许访问我们的跨域资源
                        .allowedMethods("*")           // 配置请求方法允许访问  如 GET、POST...
                        .allowedHeaders("*");          // 配置请求header允许访问
            }
        };
    }


}
