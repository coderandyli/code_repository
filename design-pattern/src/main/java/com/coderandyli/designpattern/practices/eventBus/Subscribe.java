package com.coderandyli.designpattern.practices.eventBus;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Subscribe {
}
