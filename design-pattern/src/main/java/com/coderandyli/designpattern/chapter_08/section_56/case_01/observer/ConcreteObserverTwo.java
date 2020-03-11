package com.coderandyli.designpattern.chapter_08.section_56.case_01.observer;

import com.coderandyli.designpattern.chapter_08.section_56.case_01.Message;

/**
 * 观察者1
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message msg) {
        System.out.println("class: ConcreteObserverTwo; method: update()");
    }

    @Override
    public String toString() {
        return "ConcreteObserverTwo{}";
    }
}
