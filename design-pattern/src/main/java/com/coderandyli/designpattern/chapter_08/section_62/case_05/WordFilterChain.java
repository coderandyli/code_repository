package com.coderandyli.designpattern.chapter_08.section_62.case_05;

import com.coderandyli.designpattern.chapter_08.section_62.case_05.wordFilter.SensitiveWordFilter;
import com.coderandyli.designpattern.utils.ClazzUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:56
 */
public class WordFilterChain {
    private static final List<SensitiveWordFilter> wordFilters = new ArrayList<>();
    private static final String PACKAGE_PATH = "com.coderandyli.designpattern.chapter_08.section_62.case_05.wordFilter";
    static {
        Set<Class<?>> wordFilterClasses = ClazzUtils.getClassesWithAnno(PACKAGE_PATH, WordFilter.class);
        for (Class<?> wordFilterClass : wordFilterClasses) {
            try {
                wordFilters.add((SensitiveWordFilter) wordFilterClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void doFilter(String content) {
        boolean legal = false;
        for (SensitiveWordFilter wordFilter : wordFilters) {
            legal = wordFilter.doFilter(content);
            if (!legal) {
                break;
            }
        }
        if (legal) {
            System.out.println("可以发布");
        } else {
            System.out.println("文章含有敏感词汇，禁止发布");
        }

    }
}
