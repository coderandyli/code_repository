package com.coderandyli.serializable.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lizhen on 2019-03-09
 */
@Data
public class Position {
    /**
     * id
     */
    private String id;
    /**
     * code
     */
    private String code;
    /**
     * name
     */
    private String name;
}
