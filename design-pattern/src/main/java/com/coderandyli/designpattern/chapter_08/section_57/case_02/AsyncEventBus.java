package com.coderandyli.designpattern.chapter_08.section_57.case_02;


import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}