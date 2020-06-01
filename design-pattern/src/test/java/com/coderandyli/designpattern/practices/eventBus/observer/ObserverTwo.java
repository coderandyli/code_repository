package com.coderandyli.designpattern.practices.eventBus.observer;

import com.coderandyli.designpattern.practices.eventBus.case_01.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/17 上午11:27
 */
@Slf4j
public class ObserverTwo {

    @Subscribe
    public void exec(String userId) {
        log.info("class {}, method: {} ", "ObserverTwo", "exec()");
    }
}
