package com.coderandyli.serializable.entity;

import lombok.Data;
import org.thymeleaf.context.Context;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lizhen on 2019-03-06
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -891637224676745026L;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private int age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别 （被 transient 修饰，不会被序列化）
     */
    private transient String gender; // 不被序列化

    /**
     * 用户名
     */
    public static String userName; // static 修饰的变量

    /**
     *
     */
//    public static Context context;
    public Context context;

    /**
     * 职位信息
     */
    private Manager manager;
}
