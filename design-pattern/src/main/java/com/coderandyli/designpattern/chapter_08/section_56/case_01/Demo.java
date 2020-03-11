package com.coderandyli.designpattern.chapter_08.section_56.case_01;

import com.coderandyli.designpattern.chapter_08.section_56.case_01.observer.ConcreteObserverOne;
import com.coderandyli.designpattern.chapter_08.section_56.case_01.observer.ConcreteObserverTwo;

public class Demo {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        ConcreteObserverOne observerOne = new ConcreteObserverOne();
        ConcreteObserverTwo observerTwo = new ConcreteObserverTwo();

        subject.registerObserver(observerOne);
        subject.registerObserver(observerTwo);
        subject.registerObserver(observerTwo);

        subject.notifyObservers(new Message());

//        subject.removeObserver(observerTwo);
//        System.out.println("------------------ 华丽的分割线 ------------------");
//        subject.notifyObservers(new Message());
    }

}
