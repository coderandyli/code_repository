package com.coderandyli.designpattern.chapter_08.section_62.case_04;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:49
 */
public class AdsWordFilter implements SensitiveWordFilter{
    @Override
    public boolean doFilter(String content) {
        boolean legal = true;
        legal = !content.contains("ads");
        return legal;
    }
}
