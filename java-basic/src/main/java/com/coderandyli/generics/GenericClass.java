package com.coderandyli.generics;

import lombok.Data;

/**
 * Created by lizhen on 2019-10-31
 *
 * 泛型类
 */
@Data
public class GenericClass<T> {
    private T data;

    public GenericClass(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "data=" + data +
                '}';
    }
}
