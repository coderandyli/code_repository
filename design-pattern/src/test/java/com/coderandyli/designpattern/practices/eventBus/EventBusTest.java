package com.coderandyli.designpattern.practices.eventBus;

import com.coderandyli.designpattern.practices.eventBus.observer.ObserverOne;
import com.coderandyli.designpattern.practices.eventBus.observer.ObserverTwo;
import org.junit.jupiter.api.Test;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/17 上午11:26
 */
class EventBusTest {

    @Test
    public void post() {
        EventBus eventBus = new EventBus();

        eventBus.register(new ObserverOne());
        eventBus.register(new ObserverTwo());
        eventBus.post("11");
    }

}