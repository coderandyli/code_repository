package com.coderandyli.jvm.chapter08;

import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.lookup;


/**
 * Created by lizhen on 2019-12-02
 *
 * invokedynamic指令模拟
 */
public class InvokeDynamicTest {

    public static void main(String args[]) throws Throwable {
        INDY_BootstrapMethod().invokeExact("hello invokedynamic");
    }

    public static void testMethod(String s){
        System.out.println("hello String: " + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable{
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    public static MethodType MT_BootstrapMethod(){
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);
    }

    public static MethodHandle MH_BootstrapMethod() throws Throwable{
        return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    public static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite)MH_BootstrapMethod().invokeWithArguments(lookup(),"testMethod", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }

}
