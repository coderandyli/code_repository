package com.coderandyli.copy;

import java.io.Serializable;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/1/12 下午3:52
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7977723825654478241L;
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }
}
