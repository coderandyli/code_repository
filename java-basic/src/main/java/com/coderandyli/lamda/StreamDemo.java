package com.coderandyli.lamda;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /**
     * filter 根据指定条件过滤
     *
     * 获取名字不为空的集合
     */
    @Test
    public void test05(){
        List<String> names = Arrays.asList("andy", "tina", "", "java", "js", "node", "vue");
        Stream<String> nameStream = names.stream().filter(name -> !name.isEmpty());
        List<String> filterNames = nameStream.collect(Collectors.toList());
        filterNames.forEach(System.out::println);
    }

    /**
     * limit
     * limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据
     */
    @Test
    public void test06(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    /**
     * sorted
     * 排序
     */
    @Test
    public void test07(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    /**
     * parallel
     * parallelStream 是流并行处理程序的代替方法
     */
    @Test
    public void test08(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    /**
     * Collectors
     * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
     */
    @Test
    public void test09(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * 统计
     * 一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
     */
    @Test
    public void test10(){
        List<Double> numbers = Arrays.asList(3d, 2d, 2d, 3d, 7d, 3d, 5d);

        DoubleSummaryStatistics stats = numbers.stream().mapToDouble((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
