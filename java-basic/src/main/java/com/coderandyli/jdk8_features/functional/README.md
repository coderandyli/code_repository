

# 函数式编程
- 函数式编程是一种 "编程范式", 也就是说是一种编码的"方法论"。
- 属于结构化编程的一种，主要思想是把运算过程尽量携程一系列嵌套的函数调用
- 函数式编程更加接近自然
```
# 示例
(1 + 2) * 3 - 4

# 传统写法
var a = 1 + 2;
var b = a * 3;
var c = b - 4;

# 函数式编程写法（将运算过程定义为不同的函数）
var result = subtract(multiply(add(1,2), 3), 4);

# 或 (接近自然语言，易于理解)
var result =　add(1,2).multiply(3).subtract(4) 
```

# Lamda表达式
**lamda表达式是函数式编程的载体(个人理解)**
- Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）
- 示例
```
// 1. 不需要参数,返回值为 5  
() -> 5  
  
// 2. 接收一个参数(数字类型),返回其2倍的值  
x -> 2 * x  
  
// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  
  
// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  
  
// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

# Java 对函数式编程的支持
- @FunctionalInterface注解表示是一个函数式接口
- 函数式接口有一个共同的特征 -- 有且只有一个抽象方法
```
# 1. 以 Runnable 为例
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}

# 2. 接口中只有一个抽象方法并且用@FunctionalInterfae来注解。
“约定”就是Lambda表达式只实现“接口”中唯一一个的抽象方法，在这里就是run()。
@FunctionalInterface注解表示这是一个函数式接口，这个注解只在编译时作检查，
即使没有这个注解，只要满足只有一个抽象方法的接口，都是可以作为“函数式接口“。
```
- 主要的函数式接口 (详见示例：FunctionalInterfaceTest)

name | type | description
---|---|---|---
Consumer | Consumer< T > | 消费者接口，抽象方法是void accept(T t)，接收T对象，不返回值
Predicate | Predicate< T > | 谓词接口， 抽象方法是 boolean test(T t)， 接收T对象并返回boolean。
Function | Function< T, R > | 函数接口(注意不是函数式接口），抽象方法是 R apply(T t)，接收T对象，返回R对象 。
Supplier | Supplier< T > |  提供者接口，抽象方法是T get()，该方法没有入口参数并且返回一个结果。
    
# Reference
- [函数式编程初探](http://www.ruanyifeng.com/blog/2012/04/functional_programming.html)
- [Java Lambda 表达式](https://www.runoob.com/java/java8-lambda-expressions.html)
- [Lambda表达式与函数式编程](https://zhuanlan.zhihu.com/p/136816446)