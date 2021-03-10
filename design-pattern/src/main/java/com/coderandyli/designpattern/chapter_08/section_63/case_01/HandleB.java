package com.coderandyli.designpattern.chapter_08.section_63.case_01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/30 上午11:11
 */
@Slf4j
public class HandleB implements Handle {
    @Override
    public void doHandle(HandleChain chain) {
        log.info("class HandlerB, method doHandle()");
        chain.doHandle();
    }
}
