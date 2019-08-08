package com.coderandyli.project.annotation;

import java.lang.annotation.*;

/**
 * Created by lizhen on 2019-07-10
 * 重复提交注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {
    String value() default "";
}
