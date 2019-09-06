package com.coderandyli.elasticjob.demo.common.annotation;

import com.coderandyli.elasticjob.demo.common.ElasticJobAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Enable ad job
 *
 * @author Hanping QIAO
 * 2018-09-25 下午3:56
 **/

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(ElasticJobAutoConfiguration.class)
public @interface EnableJob {
}
