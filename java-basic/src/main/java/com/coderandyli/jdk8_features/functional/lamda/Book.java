package com.coderandyli.jdk8_features.functional.lamda;

import lombok.Data;

/**
 * Created by lizhen on 2019-05-19
 */
@Data
public class Book {

    private String name;

    private int price;

    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        // 1、自反性 (是否是同一对象)
        if (this == obj) return true;

        // 比较是否是同一类型
        if (getClass() != obj.getClass()) return false;

        // 类型转换
        final Book book = (Book) obj;

        // 比较属性
        return (this.name.equals(book.name) && this.price == book.price);
    }

    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
        return hashno;
    }


}
