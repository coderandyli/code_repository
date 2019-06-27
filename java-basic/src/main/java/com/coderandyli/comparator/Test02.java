package com.coderandyli.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lizhen on 2019-06-04
 */
public class Test02 {


    List<Test02.User> users = new ArrayList<Test02.User>() {
        {
            add(new Test02.User(1, "aaa", 1));
            add(new Test02.User(2, "ddd", 2));
            add(new Test02.User(3, "ccc", 0));
            add(new Test02.User(4, "bbb", 3));
            add(new Test02.User(5, "eee", 0));
        }
    };

    /**
     * // 指派任务的完成状态:0:等待开始,1:进行中,2:已完成 3:已取消
     * <p>
     * 状态为 1 的排在最前面，其他的按照 升序
     */
    @Test
    public void test() {
        // 1.3 根据id排序 正序 （lamda）
        Collections.sort(users, (o1, o2) -> {
            Integer status1 = o1.getStatus();
            Integer status2 = o2.getStatus();
            if (1 == status1) {
                return -1;
            }
            if (1 == status2) {
                return 1;
            }
            return status2.compareTo(status1);
        });

        users.forEach(user -> System.out.println(user.getStatus()));
    }

    @Test
    public void test01() {
        List<String> users = new ArrayList<String>() {
            {
                add("111111");
                add("111111");
                add("111111");
                add("222222");
                add("222222");
                add("333333");
            }
        };


        Test02.removeDuplicate(users).forEach(System.out::println);
    }


    /**
     * List 去重
     *
     * @param list
     * @return
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }


    /**
     * user 静态内部类
     */
    private class User {
        private int id;
        private String name;
        private Integer status;

        public User(int id, String name, Integer status) {
            this.id = id;
            this.name = name;
            this.status = status;
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

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }
}
