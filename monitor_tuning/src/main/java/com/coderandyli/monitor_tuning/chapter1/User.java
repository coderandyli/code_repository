package com.coderandyli.monitor_tuning.chapter1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by lizhen on 2019-04-18
 */
//@Data
//@AllArgsConstructor
public class User {

    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
