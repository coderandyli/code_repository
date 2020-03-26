package com.coderandyli.designpattern.chapter_08.section_62.case_04;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:55
 */
public class Application {
    public static void main(String[] args) {
        WordFilterChain filterChain = new WordFilterChain();
        filterChain.addwordFilter(new AdsWordFilter());
        filterChain.addwordFilter(new PoliticalWordFilter());
        filterChain.addwordFilter(new SexyWordFilter());
        filterChain.doFilter("金三胖统治下的朝鲜人民军所向披靡");
        filterChain.doFilter("this is a healthy message");
    }
}
