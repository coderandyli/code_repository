package com.coderandyli.designpattern.chapter_08.section_57.case_02;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Order(1)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Subscribe {

}
