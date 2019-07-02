package com.coderandyli.redis.demo.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by lizhen on 2018-12-16
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 可以定义多个组
     *
     */
    @Bean
    public Docket devApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler requestHandler) {
                Class<?> declaringClass = requestHandler.declaringClass();
                if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                if(requestHandler.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                    return true;
                return false;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }
        };

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("dev")
                .genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(or(regex("/.*")))//过滤的接口
                .apis(predicate)
                .build()
                .apiInfo(devApiInfo());
    }

    private ApiInfo devApiInfo() {
        return new ApiInfoBuilder()
                .title("eports接口文档（开发）")//大标题
                .description("eports接口文档详细描述")//详细描述
                .version("1.0")//版本
//                .termsOfServiceUrl("NO terms of service")
//                .contact(new Contact("ad", "http://www.e-ports.com", "li.zhenzhen@eports.com"))
//                .license("The Apache License, Version 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
