package com.coderandyli.jvm.chapter08.section_03.b_dispatch;

/**
 * Created by lizhen on 2019-11-30
 *
 * 单分派、多分派演示
 *
 * 知识点
 *  1、方法的接受者与方法的参数统称为方法的宗量
 *  2、Java语言是一门静态多分派、动态单分派的语言
 *
 * 字节码文件
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=3, locals=3, args_size=1
 *          0: new           #2                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$Father
 *          3: dup
 *          4: invokespecial #3                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$Father."<init>":()V
 *          7: astore_1
 *          8: new           #4                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$Son
 *         11: dup
 *         12: invokespecial #5                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$Son."<init>":()V
 *         15: astore_2
 *         16: aload_1
 *         17: new           #6                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$_360
 *         20: dup
 *         21: invokespecial #7                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$_360."<init>":()V
 *         24: invokevirtual #8                  // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$Father.hardChoice:(Lcom/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$_360;)V
 *         27: aload_2
 *         28: new           #9                  // class com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$QQ
 *         31: dup
 *         32: invokespecial #10                 // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$QQ."<init>":()V
 *         35: invokevirtual #11                 // Method com/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$Father.hardChoice:(Lcom/coderandyli/jvm/chapter08/section_02/b_dispatch/d_Dispatch$QQ;)V
 *         38: return
 *       LineNumberTable:
 *         line 12: 0
 *         line 13: 8
 *         line 14: 16
 *         line 15: 27
 *         line 16: 38
 *  }
 *
 *
 * 执行过程分析
 *  编译期即静态分派过程（确定静态类型）
 *      1、确定静态类型是Father还是Son
 *      2、方法入参是QQ还是_360
 *      因为静态分派过程是根据两个宗量进行选择，所以静态分派是多分派类型
 *  运行期即动态分派过程 （确定动态类型）
 *      已 son.hardChoice(new QQ()); 为例
 *      在执行到invokevirtual指令时，已经确定其目标方法的签名必须为hardChoice(QQ)，此时对分派结果有影响的是只有接受者的实际类型是Father还是Son（即只有一个宗量作为选择依据）
 *      所以动态分派是单分派类类型
 *
 */
public class d_Dispatch {

    public static void main(String args[]) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

    static class QQ{};

    static class _360{};

    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg){
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father{
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg){
            System.out.println("son choose 360");
        }
    }
}
