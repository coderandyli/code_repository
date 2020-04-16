package com.coderandyli.designpattern.chapter_08.section_62.case_05.wordFilter;

import com.coderandyli.designpattern.chapter_08.section_62.case_05.WordFilter;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:53
 */
@WordFilter
public class PoliticalWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(String content) {
        boolean legal = true;
        legal = !content.contains("金三胖");
        return legal;
    }
}