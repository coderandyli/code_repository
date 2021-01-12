package com.coderandyli.copy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * shallow copy（浅拷贝） 与 deep copy（深拷贝）
 *
 * Java 中clone()采用的是浅拷贝，它只会拷贝对象中的基本数据类型的数据（比如，int、long），以及引用对象（SearchWord）的内存地址，不会递归地拷贝引用对象本身
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2021/1/12 下午3:47
 */
public class CopyTest {

    public static void main(String[] args) {
//        testShallowCopy();
        testDeepCppy();
    }

    public static void testDeepCppy() {
        List<User> src = new ArrayList<>();
        src.add(
                new User("a")
        );
        src.add(
                new User("b")
        );
        src.add(
                new User("c")
        );
        src.add(
                new User("d")
        );

//        List<User> dest = new ArrayList<>();
//        CollectionUtils.addAll(dest, new User[src.size()]);
//        Collections.copy(dest, src);

        List<User> dest = depCopy(src);

        for (User user : src) {
            System.out.println(user);
        }

        System.out.println("------------------------------------------------------------");

        for (User user : dest) {
            System.out.println(user);
        }
    }

    /**
     * shallow copy test
     * <p>
     * - addAll()、add()、Collections.copy 都是浅拷贝
     */
    public static void testShallowCopy() {
        List<User> src = new ArrayList<>();
        src.add(
                new User("a")
        );
        src.add(
                new User("b")
        );
        src.add(
                new User("c")
        );
        src.add(
                new User("d")
        );

        List<User> dest = new ArrayList<>();
        dest.addAll(src);

        for (User user : src) {
            System.out.println(user);
        }

        System.out.println("------------------------------------------------------------");

        for (User user : dest) {
            System.out.println(user);
        }
    }


    /***
     * 方法一对集合进行深拷贝 注意需要对泛型类进行序列化(实现Serializable)
     *
     * @param srcList
     * @param <T>
     * @return
     */
    public static <T> List<T> depCopy(List<T> srcList) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(srcList);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream inStream = new ObjectInputStream(byteIn);
            return (List<T>) inStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
