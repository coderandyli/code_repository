# 泛型
## 概念 
 泛型的本质是参数化类型
 
## 类型擦除 Type Erasure
 - 发生在编译器
 - 编译期提供类型检查以及消除类型转换： 
    - 这也正是泛型的好处之一，可以提前暴露问题，而不是等到运行时出现ClassCastException。编译器会在编译时对泛型类型进行检测，并把它重写成实际的对象类型(非泛型代码)，这样就可以被JVM执行了。这个过程被称为"类型擦除"。
    - eg: 编译 javac BoundedTypeParametersTest.java查看


## Java泛型中的标记符含义（可以使用任意大写字母替换） 

 - E - Element (在集合中使用，因为集合中存放的是元素) 

 - T - Type（Java 类） T代表在调用时的指定类型

 - K - Key（键）

 - V - Value（值）

 - N - Number（数值类型）

 - ？ -  表示不确定的java类型  一般用在通配
 
 - <? extends A>  上限有界通配符，泛型参数一般是A类型或者A子类型
 
 - <? super A>    下限有界通配符，泛型类型一般是A类型或者A的父类型
 
 
## List<T>、List<?>、List<Object>这三者都可以容纳所有的对象，但使用的顺序应该是首选List<T>，次之List<?>，最后选择List<Object>
 - List<T>是确定的某一个类型， List<T>可以进行读写操作
 - List<?>是只读操作的，不能进行增加、修改操作

 
 
 ## Reference
 
 - [Java泛型](https://www.runoob.com/java/java-generics.html)
 - [Java 泛型中的 ? T K V E等代表的意思](https://blog.csdn.net/wqc19920906/article/details/78118984)
 - [Java泛型-1(泛型的定义)](https://www.jianshu.com/p/0860cbf0606f)  推荐阅读
 - [Java泛型的类型擦除](https://www.cnblogs.com/joeblackzqq/p/10813143.html)