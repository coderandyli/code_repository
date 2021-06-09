# Java 对函数式编程的支持

# 函数式编程
- 函数式编程是一种 "编程范式", 也就是说是一种编码的"方法论"。
- 属于结构化编程的一种，主要思想是把运算过程尽量携程一系列嵌套的函数调用
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
    
# Reference
- [函数式编程初探](http://www.ruanyifeng.com/blog/2012/04/functional_programming.html)