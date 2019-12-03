package com.coderandyli.jvm.chapter08.section_02;

/**
 * Created by lizhen on 2019-11-28
 *
 * 局部变量表Slot复用以及GC内存回收测试
 *
 * 测试前知识
 *  Slot是可以重用的，方法体中定义的变量作用域不一定覆盖整个方法体，如果超出变量的作用域，其变量的slot就可以交给其他变量使用了
 *      - 这样设计可以节省栈帧的空间
 *      - 但是，某些情况下，Slot复用会直接影响到系统的GC行为
 *
 * 运行参数
 *  -verbose:gc
 *
 * 结论
 *  placeholder 能否被回收的根本原因：
 *      局部变量表中的Slot是否还有关于placeholder的引用，
 *
 */
public class a_SlotTest {

    public static void main(String args[]) {
        test_8_3();
    }

    /**
     *
     * 执行结果
     *   [GC (System.gc())  70205K->66447K(125952K), 0.0026654 secs]
     *   [Full GC (System.gc())  66447K->66344K(125952K), 0.0078037 secs]
     *
     * 执行结果
     *  内存未回收
     *
     * 结论
     *  GC时，placeholder还在作用域内
     */
    public static void test_8_1(){
        byte[] placeholder = new byte[64*1024*1024];
        System.gc();
    }

    /**
     *
     * 执行结果
     *   [GC (System.gc())  70205K->66479K(125952K), 0.0029275 secs]
     *   [Full GC (System.gc())  66479K->66344K(125952K), 0.0123771 secs]
     *
     * 执行结果
     *  内存未回收
     *
     * 结论
     *  placeholder虽然已不再作用域内，但之后没有对局部变量表有任何的读写操作，
     *  placeholder所占用的Slot没有被其他变量复用，所以CG Roots一部分的局部
     *  变量表仍然保持着对它的引用
     */
    public static void test_8_2(){
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        System.gc();
    }

    /**
     *
     * 执行结果
     *   [GC (System.gc())  70205K->66479K(125952K), 0.0118850 secs]
     *   [Full GC (System.gc())  66479K->808K(125952K), 0.0263553 secs]
     *
     * 执行结果
     *  内存回收
     *
     * 结论
     *  参考 test_8_1,test_8_2
     */
    public static void test_8_3(){
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        int a = 0;
        System.gc();
    }

}
