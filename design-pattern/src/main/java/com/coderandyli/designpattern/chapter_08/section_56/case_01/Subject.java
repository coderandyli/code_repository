package com.coderandyli.designpattern.chapter_08.section_56.case_01;

import com.coderandyli.designpattern.chapter_08.section_56.case_01.observer.Observer;

public interface Subject {
    /**
     * register observer
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * remove observer
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * notify observers
     * @param message
     */
    void notifyObservers(Message message);
}
