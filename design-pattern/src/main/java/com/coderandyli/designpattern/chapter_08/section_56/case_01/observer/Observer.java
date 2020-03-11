package com.coderandyli.designpattern.chapter_08.section_56.case_01.observer;

import com.coderandyli.designpattern.chapter_08.section_56.case_01.Message;

/**
 * 观察者接口
 */
public interface Observer {
    void update(Message msg);
}
