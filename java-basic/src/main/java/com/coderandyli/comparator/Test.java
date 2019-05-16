package com.coderandyli.comparator;

import java.util.*;

/**
 * Created by lizhen on 2019-05-16
 * <p>
 * Comparator 实现排序
 */
public class Test {

    /**
     * 数组的简单排序 comparator + lamda
     */
    @org.junit.Test
    public void test01() {

        String[] names = {
                "a-f",
                "c-d",
                "e-b",
                "d-c",
                "b-e",
                "f-a"
        };

        // 1.1 根据首字母 正序
        // Arrays.sort(names, (String o1, String o2) -> o1.compareTo(o2));

        // 1.2 根据首字母 逆序
        // Arrays.sort(names, (String o1, String o2) -> o2.compareTo(o1));

        // 2.1 根据尾字母 正序
        // Arrays.sort(names, (String o1, String o2) -> o1.substring(o1.length() - 1).compareTo(o2.substring(o2.length() - 1)));

        // 2.2 根据尾字母 逆序
        Arrays.sort(names, (String o1, String o2) -> o2.substring(o2.length() - 1).compareTo(o1.substring(o1.length() - 1)));

        // 打印
        Arrays.asList(names).forEach(System.out::println);
    }

    /**
     * 集合的简单排序
     */
    @org.junit.Test
    public void test02() {
        Test test = new Test();

        List<Test.User> users = new ArrayList();
        users.add(new Test.User(1, "aaa"));
        users.add(new Test.User(4, "ddd"));
        users.add(new Test.User(3, "ccc"));
        users.add(new Test.User(2, "bbb"));
        users.add(new Test.User(5, "eee"));

        // 1.1 根据id排序 正序 （内部类实现）
        /*Collections.sort(users, test.new CompareIds(true));*/

        // 1.2 根据id排序 倒序 （内部类实现）
        /*Collections.sort(users, test.new CompareIds(false));*/

        // 1.3 根据id排序 正序 （lamda）
       /* Collections.sort(users, (o1, o2) -> {
            int id1 = o1.getId();
            int id2 = o2.getId();

            if (id1 > id2)
                return 1;
            else if (id1 == id2)
                return 0;
            else
                return -1;
        });*/

        // 2.1 根据name 排序 正序
        /*Collections.sort(users, (o1, o2) -> o1.getName().compareTo(o2.getName()));*/

        // 2.2 根据name 排序 正序
        /*Collections.sort(users, Comparator.comparing(User::getName));*/

        // 2.3 根据name 排序 逆序
        Collections.sort(users, (o1, o2) -> o2.getName().compareTo(o1.getName()));

        // 打印 id
        users.forEach(user -> {
            System.out.println(user.getName());
        });
    }

    /**
     * 根据id 排序 正序 / 倒序
     */
    private class CompareIds implements Comparator<Test.User> {
        // 是否升序
        boolean asced;

        public CompareIds(boolean asced) {
            this.asced = asced;
        }

        @Override
        public int compare(Test.User u1, Test.User u2) {

            int id1 = asced ? u1.getId() : u2.getId();
            int id2 = asced ? u2.getId() : u1.getId();

            if (id1 > id2)
                return 1;
            else if (id1 == id2)
                return 0;
            else
                return -1;
        }
    }

    /**
     * user 静态内部类
     */
    private class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
