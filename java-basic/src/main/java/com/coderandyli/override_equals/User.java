package com.coderandyli.override_equals;

import lombok.Data;

import java.util.Objects;

/**
 * Created by lizhen on 2019-05-19
 */
@Data
public class User {
    /**
     * name
     */
    private String name;
    /**
     * age
     */
    private int age;

    @Override
    public boolean equals(Object obj) {
        // 1、自反性 (是否是同一对象)
        if (this == obj) return true;

        // null一律返回fase
        if (obj == null) return false;

        // 比较是否是同一类型, 择一
        if (getClass() != obj.getClass()) return false;
        if (!(obj instanceof User)) return false; // 本类及其子类均可

        // 强制类型转换
        User user = (User) obj;

        //比较属性值，根据具体业务需求
        return this.name.equals(user.name);
    }

    @Override
    public int hashCode() {
        //如果equalse方法比较的是name，那么hashCode方法就要散列name
        return Objects.hash(name);
    }

}
