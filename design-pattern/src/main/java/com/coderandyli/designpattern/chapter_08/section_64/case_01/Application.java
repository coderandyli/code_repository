package com.coderandyli.designpattern.chapter_08.section_64.case_01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/31 上午10:56
 */
@Slf4j
public class Application {
    public static void main(String[] args) {
        MarioStateMachine stateMachine = new MarioStateMachine(10);
        stateMachine.obtainMushRoom();
        stateMachine.obtainCape();
        stateMachine.obtainFireFlower();
        log.info("status = {}, score = {}",stateMachine.getName(), stateMachine.getScore());
    }
}
