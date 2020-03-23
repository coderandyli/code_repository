package com.coderandyli.designpattern.chapter_08.section_57.case_02;

public class Main {
    private EventBus eventBus;

    public Main() {
        this.eventBus = new EventBus();
        register();
    }

    public void register() {
        eventBus.register(new Test());
    }

    public void post() {
        eventBus.post(new Main());
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.post();
    }
}
