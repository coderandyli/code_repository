package com.coderandyli.jdk8_features.functional.stream;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/25 下午3:50
 */
public class StreamTest {

    public static void main(String[] args) {
        Optional<Integer> result = Stream.of("f", "ba", "hello") // of返回Stream<String>对象
                .map(s -> s.length()) // map返回Stream<Integer>对象
                .filter(l -> l <= 3) // filter返回Stream<Integer>对象
                .max((o1, o2) -> o1 - o2); // max终止操作：返回Optional<Integer>
        System.out.println(result.get()); // 输出2
    }

}
