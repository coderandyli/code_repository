package com.coderandyli.RESTful.entity;

import com.coderandyli.RESTful.utils.ZooStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by lizhen on 2019-08-31
 */
@AllArgsConstructor
@Data
public class Zoo {

    private long id;

    private String name;

    private String address;

    private ZooStatus status;

    public Zoo(){

    }
}
