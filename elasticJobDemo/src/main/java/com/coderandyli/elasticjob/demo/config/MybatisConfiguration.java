package com.coderandyli.elasticjob.demo.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis Configuration
 *
 * @author Hanping QIAO
 * 2018-08-28 上午10:09
 **/
@Configuration
@MapperScan("com.eports.ad.ws.job.mapper")
public class MybatisConfiguration {

    /**
     * Mybatis Pagination Configuration
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
