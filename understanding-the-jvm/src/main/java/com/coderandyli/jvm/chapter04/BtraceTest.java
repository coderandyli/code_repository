package com.coderandyli.jvm.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lizhen on 2019-12-23
 * 演示JVisalVM 插件BTrace的使用
 *
 *
 *
 *
 *
 *
 */
public class BtraceTest {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String args[]) throws IOException {
        BtraceTest test = new BtraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() *1000);
            int b = (int) Math.round(Math.random() *1000);
            System.out.println(test.add(a, b));
        }
    }
}



//todo 没有执行成功
///* BTrace Script Template */
//import com.sun.btrace.annotations.*;
//        import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TracingScript {
//    /* put your code here */
//    @OnMethod(
//            classzz = "com.coderandyli.jvm.chapter04.BtraceTest",
//            method = "add",
//            location=@Location(Kind.RETURN)
//    )
//
//    public static void func (@Self com.coderandyli.jvm.chapter04.BtraceTest instance, int a, int b, @Return int result){
//        println("调用堆栈");
//        jstack();
//        println(strcat("方法参数A:",str(a)));
//        println(strcat("方法参数B:",str(b)));
//        println(strcat("方法结果:",str(result)));
//    }
//}
