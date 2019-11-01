package com.coderandyli.reflect;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lizhen on 2019-10-29
 *
 * Java的反射就是利用加载到jvm中的.class文件(字节码文件)来进行操作的。.class文件中包含java类的所有信息，当你不知道某个类具体信息时，可以使用反射获取class，然后进行各种操作。
 * Java反射就是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；并且能改变它的属性。
 * 总结说：反射就是把java类中的各种成分映射成一个个的Java对象，并且可以进行操作。
 */
@Slf4j
public class ReflectClass {
    private static Class<?> classBook = null;
    static {
        try {
            log.debug("into static code block");
            classBook = Class.forName("com.coderandyli.reflect.Book");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ReflectClass.reflectPrivateMethod();
    }

    /**
     * 创建对象
     */
    public void reflectNewInstance() {
        try {
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("深入理解Java虚拟机");
            book.setAuthor("周志明");
            log.debug("reflectNewInstance book = {}", book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有的构造方法
     */
    public static void reflectPrivateConstructor() {
        try {
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
            declaredConstructorBook.setAccessible(true); // 取消访问控制检查
            Object objectBook = declaredConstructorBook.newInstance("深入理解JVM","周志明");
            Book book = (Book) objectBook;
            log.debug("reflectPrivateConstructor book = {}", book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有属性
     */
    public static void reflectPrivateField() {
        try {
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true); // 取消访问控制检查
            String tag = (String) fieldTag.get(objectBook);
            log.debug("reflectPrivateField tag = {}", tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有方法
     */
    public static void reflectPrivateMethod() {
        try {
            Method methodBook = classBook.getDeclaredMethod("declaredMethod",int.class);
            methodBook.setAccessible(true); // 取消访问权限检查
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook,0);
            log.debug("reflectPrivateMethod string = {}", string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}