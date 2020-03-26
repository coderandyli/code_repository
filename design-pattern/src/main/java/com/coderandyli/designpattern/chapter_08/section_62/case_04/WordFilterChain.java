package com.coderandyli.designpattern.chapter_08.section_62.case_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:56
 */
public class WordFilterChain {
    private List<SensitiveWordFilter> wordFilters = new ArrayList<>();

    public void addwordFilter(SensitiveWordFilter wordFilter) {
        wordFilters.add(wordFilter);
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
