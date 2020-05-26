package com.coderandyli.jdk8_features.functional;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by lizhen on 2019-11-12
 * <p>
 * 函数式编程
 */
public class Main {

    public static void main(String[] args) {
        test_03();
    }

    /**
     * 典型的函数式编程代码
     *      过滤出长度小于等于 3 的字符串，并且求得这其中的最大长度
     */
    public static void test_03() {
        Optional<Integer> result = Stream.of("f", "ba", "hello")
                .map(s -> s.length())
                .filter(l -> l <= 3)
                .max((o1, o2) -> o1 - o2);
        System.out.println(result.get()); // 输出2
    }
}
