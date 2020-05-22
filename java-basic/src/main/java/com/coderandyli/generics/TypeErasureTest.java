package com.coderandyli.generics;

/**
 * Created by lizhen on 2019-12-13
 * 类型擦除测试
 */
public class TypeErasureTest {

    /**
     * T -> Object
     * @param <T>
     */
    public class test_01<T> {
        private T value;
        public T getValue() {
            return value;
        }
    }

    /**
     * T -> Number
     * @param <T>
     */
    public class test_02<T extends Number> {
        private T value;
        public T getValue() {
            return value;
        }
    }

}
