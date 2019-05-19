package com.coderandyli.lamda;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lizhen on 2019-05-19
 * <p>
 * Lamda Stream 的演示代码
 */
public class StreamDemo {

    /**
     * forEach : 迭代流中的每个数据
     * 输出10个随机数
     */
    @Test
    public void test01() {
        Random random = new Random();
        IntStream ints = random.ints();
        ints.limit(10).forEach(System.out::println);
    }

    /**
     * map: 映射每个元素到对应的结果。
     *
     * 输出元素对应的平方数, 并去重
     */
    @Test
    public void test02(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * distinct()
     * distinct()的去重是基于equals 和 hashCode实现的
     */
    @Test
    public void test03(){
        List<Book> list = new ArrayList<>();
        {
           list.add(new Book("Core Java", 200));
           list.add(new Book("Core Java", 200));
           list.add(new Book("Learning Freemarker", 150));
           list.add(new Book("Spring MVC", 300));
           list.add(new Book("Spring MVC", 300));
        }

        long count = list.stream().distinct().count();
        System.out.println("No. of distinct books: " + count);
        list.stream().distinct().forEach(book -> System.out.println(book.getName() + ", " +book.getPrice()));
    }

    /**
     *  distinct 不提供按照属性对对象列表进行去重的直接实现，我们可以通过如下方法（distinctByKey）实现根据指定属性对列表去重
     */
    @Test
    public void test04(){
        List<Book> list = new ArrayList<>();
        {
            list.add(new Book("Core Java", 200));
            list.add(new Book("Core Java", 200));
            list.add(new Book("Learning Freemarker", 150));
            list.add(new Book("Spring MVC", 300));
            list.add(new Book("Spring MVC", 300));
        }
        list.stream().filter(distinctByKey(b -> b.getName()))
                .forEach(book -> System.out.println(book.getName()+ "," + book.getPrice()));
    }

    // TODO: 2019-05-19 不是很懂
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}
