package com.coderandyli.jvm.chapter08.section_03.b_dispatch;

/**
 * Created by lizhen on 2019-11-29
 * <p>
 * 方法调用 之 动态分派
 * <p>
 * 测试前知识
 * 在运行期根据实际类型确认方法的执行版本的分派过程称为动态分派
 * <p>
 * <p>
 * Main方法字节码
 * public static void main(java.lang.String[]);
 * descriptor: ([Ljava/lang/String;)V
 * flags: ACC_PUBLIC, ACC_STATIC
 * Code:
 * stack=2, locals=3, args_size=1
 * 0: new           #2                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Man
 * 3: dup
 * 4: invokespecial #3                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Man."<init>":()V
 * 7: astore_1
 * 8: new           #4                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Woman
 * 11: dup
 * 12: invokespecial #5                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Woman."<init>":()V
 * 15: astore_2
 * 16: aload_1
 * 17: invokevirtual #6                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Humen.sayHello:()V
 * 20: aload_2
 * 21: invokevirtual #6                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Humen.sayHello:()V
 * 24: new           #4                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Woman
 * 27: dup
 * 28: invokespecial #5                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Woman."<init>":()V
 * 31: astore_1
 * 32: aload_1
 * 33: invokevirtual #6                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/c_DynamicDispatch$Humen.sayHello:()V
 * 36: return
 * <p>
 * 【17】、【21】invokevirtual指令运行时解析过程如下
 * - 1> 找到操作数栈栈顶的第一个元素所指向的对象实际类型，记作C
 * - 2> 如果在类型C中找到与常量中的描述符和简单名称都相符的方法，则进行权限校验，如果通过则返回这个方法的直接引用，查找过程结束；如果不通过，则返回java.lang,IllegalAccessError异常
 * - 3> 否则按照继承关系从下往上依次对C的各个父类进行第2步的搜索和验证过程
 * - 4> 如果始终没有找到合适的方法，则抛出java.lang.AbstractMethodError异常
 */
public class c_DynamicDispatch {

    public static void main(String args[]) {
        Humen man = new Man();
        Humen women = new Woman();
        man.sayHello();
        women.sayHello();
        man = new Woman();
        man.sayHello();

        // 在实际类型中找不到对应的方法，则按照继承关系依次搜索、验证其父类
        Humen mother = new Mother();
        mother.sayHello();
    }

    /**
     * =============================================================================
     * =========          extends             =========
     * =============================================================================
     */
    static abstract class Humen {
        /**
         * sayhello 抽象方法
         */
        // abstract void sayHello();

        /**
         * say hello
         */
        void sayHello() {
            System.out.println("hello humen");
        }
    }

    static class Man extends Humen {
        @Override
        protected void sayHello() {
            System.out.println("hello man");
        }
    }

    static class Woman extends Humen {
        @Override
        protected void sayHello() {
            System.out.println("hello woman");
        }
    }

    static class Mother extends Woman {
        /*
        @Override
        protected void sayHello() {
            System.out.println("hello mother");
        }
        */
    }


    /**
     * =============================================================================
     * =========          interface             =========
     * =============================================================================
     */

    /*interface Humen{
        void sayHello();
    }

    static class Man implements Humen {
        @Override
        public void sayHello() {
            System.out.println("hello man");
        }
    }

    static class Woman implements Humen {
        @Override
        public void sayHello() {
            System.out.println("hello woman");
        }
    }

    static class Mother extends Woman {
        @Override
        public void sayHello() {
            System.out.println("hello mother");
        }
    }*/
}
