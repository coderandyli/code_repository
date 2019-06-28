package com.coderandyli.override_equals;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * Created by lizhen on 2019-05-19
 */
@AllArgsConstructor
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


//    @Override
//    public boolean equals(Object obj) {
//
//        // null一律返回fase
//        if (obj == null) return false;
//
//        // 1、自反性 (是否是同一对象)
//        if (this == obj) return true;
//
//        // 比较是否是同一类型, 择一
//        if (getClass() != obj.getClass()) return false;
//        if (!(obj instanceof User)) return false; // 本类及其子类均可
//
//        // 强制类型转换
//        User user = (User) obj;
//
//        //比较属性值，根据具体业务需求
//        return this.name.equals(user.name);
//    }
//
//    @Override
//    public int hashCode() {
//        //如果equalse方法比较的是name，那么hashCode方法就要散列name
//        return Objects.hash(name);
//    }

}
