# 第八章 虚拟机字节码执行引擎笔记

virtual [ˈvɜːrtʃuəl]
第八章  虚拟机字节码执行引擎

1、虚拟机字节码执行引擎的概念模型
1、字节码执行引擎执行过程： 
	字节码文件 —> 字节码解析（解释执行/编译执行） —> 执行结果
1、局部变量表的大小，操作数栈深度，在编译期就确定了，并且写入到方法表的code属性中。
1、局部变量表的最小单位为变量槽(Variable Slot)， 并没有明确规定Slot的大小，随着硬件设备而变化（32bit或64bit）
1、JVM是使用局部变量表完成参数值到参数变量列表的传递过程的
1、Slot是可以重用的，方法体中定义的变量作用域不一定覆盖整个方法体，如果超出变量的作用域，其变量的slot就可以交给其他变量使用了


操作数栈
 

## 方法调用
### 解析调用
所有方法调用中的目标方法在Class文件里面都是一个常量池中的符号引用，在类加载的解析阶段，会将其中的一部分符号引用转换为直接引用，即“编译期可知，运行期不可变”， 满足这个要求的方法主要包括静态方法和私有方法两大类。
解析调用一定是静态的过程，在编译期间就完全确定。

#### 分派调用
- 静态分派
    想看代码注释
- 动态分派
    - 想看代码注释
    - 虚拟机动态分派的实现: 
	    大部分通过在方法区维护一个虚方法表（Vritual Method Table）来实现，方法表中存放着每个方法的实际入口地址
	    
	    
#### 动态类型语言  
动态类型语言：类型检查的主体过程是在运行期而不是在编译期, “变量无类型，变量值才有类型” 是动态类型语言的一个重要特征

Java在编译器就已经将完整的符号引用生成出来，存储在class文件： 

java.lang.invoke包
	之前单纯依靠符号引用来确定调用目标方法
	java.lang.invoke包提供了一种新的动态确认目标方法的机制，称为MethodHandle

invokedynamic 与其他invoke*最大的区别是他的分派逻辑不是有虚拟机决定的，而是有程序员决定。


基于栈的字节码解释执行引擎
	- 解释执行
	- 编译执行


基于栈的解释器的执行过程
	


