package com.coderandyli.monitor_tuning.chapter1;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by lizhen on 2019-04-18
 */
@Data
@AllArgsConstructor
public class User {

    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;
}
