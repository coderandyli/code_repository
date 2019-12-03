package com.coderandyli.jvm.chapter08.section_03.b_dispatch;

/**
 * Created by lizhen on 2019-11-29
 *  方法调用 之 静态分派
 *
 * 测试前知识
 *  Humen man = new Man();
 *  如上 外观类型(Apparent Type) 是Humen, 实际类型(Actual Type)是Man; 外观类型在编译器可知，实际类型在运行期才能确认
 *
 *   - 依赖静态类型定位方法执行版本的分派动作称为静态分派（Dispatch这个词一般不用在静态环境中，英文技术文档的称呼是Method Overload Resolution, 但国内资料都普遍将这一行为称为静态分派）
 *   - 静态分派最典型应用是方法重载
 *
 *
 * 运行结果
 *  hello humen
 *  hello humen
 *
 *
 * 字节码
 *  public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=4, args_size=1
 *          0: new           #7                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch$Man
 *          3: dup
 *          4: invokespecial #8                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch$Man."<init>":()V
 *          7: astore_1
 *          8: new           #9                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch$Woman
 *         11: dup
 *         12: invokespecial #10                 // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch$Woman."<init>":()V
 *         15: astore_2
 *         16: new           #11                 // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch
 *         19: dup
 *         20: invokespecial #12                 // Method "<init>":()V
 *         23: astore_3
 *         24: aload_3
 *         25: aload_1
 *         26: invokevirtual #13                 // Method sayHello:(Lcom/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch$Humen;)V
 *         29: aload_3
 *         30: aload_2
 *         31: invokevirtual #13                 // Method sayHello:(Lcom/coderandyli/jvm/chapter08/section_02/b_dispatch/a_StaticDispatch$Humen;)V
 *         34: return
 *
 *
 */
public class a_StaticDispatch {

    static abstract class Humen{

    }

    static class Man extends Humen{

    }

    static class Woman extends Humen{

    }

    public void sayHello(Humen humen){
        System.out.println("hello humen");
    }

    public void sayHello(Man man){
        System.out.println("hello man");
    }

    public void sayHello(Woman women){
        System.out.println("hello women");
    }

    public static void main(String args[]) {
        Humen man = new Man();
        Humen woman = new Woman();

        a_StaticDispatch sd = new a_StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }

}
