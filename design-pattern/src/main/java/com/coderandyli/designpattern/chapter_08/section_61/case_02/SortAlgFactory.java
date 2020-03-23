package com.coderandyli.designpattern.chapter_08.section_61.case_02;

import com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg.ISortAlg;
import com.coderandyli.designpattern.utils.ClazzUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/23 上午10:33
 */
public class SortAlgFactory {
    private final static Map<String, ISortAlg> sortAlgs = new HashMap<>();
    private final static String PACKAGE_NAME = "com.coderandyli.designpattern.chapter_08.section_61.case_02.sortAlg";
    static {
        // 通过反射获取到@SortAlg修饰的类
        Set<Class<?>> classes = ClazzUtils.getClassesWithAnno(PACKAGE_NAME,
                SortAlg.class);
        for (Class<?> clazz : classes) {
            try {
                String[] names = clazz.getName().split("\\.");
                String name = names[names.length - 1];
                sortAlgs.put(name, (ISortAlg) clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return sortAlgs.get(type);
    }
}
