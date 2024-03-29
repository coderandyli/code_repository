package com.coderandyli.designpattern.chapter_08.section_64.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/31 上午10:22
 */
public interface Mario {
    /**
     * 获取状态
     * @return
     */
    Status getName();

    /**
     *  吃了蘑菇
     */
    void obtainMushRoom(MarioStateMachine stateMachine);

    /**
     * 获得斗篷
     */
    void obtainCape(MarioStateMachine stateMachine);

    /**
     * 获得火焰
     */
    void obtainFireFlower(MarioStateMachine stateMachine);

    /**
     * 遇到怪物
     */
    void meetMonster(MarioStateMachine stateMachine);
}
