package com.coderandyli.designpattern.chapter_08.section_64.case_02;

import com.coderandyli.designpattern.chapter_08.section_64.case_02.mariostatus.SmallMario;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/30 下午5:44
 */
public class MarioStateMachine {
    private int score;
    private Mario currentStatus;

    public MarioStateMachine(int score) {
        this.score = score;
        this.currentStatus = new SmallMario();
    }

    /**
     * 获取状态
     * @return
     */
    Status getName(){
        return currentStatus.getName();
    }

    /**
     *  吃了蘑菇
     */
    void obtainMushRoom(MarioStateMachine stateMachine){
        currentStatus.obtainMushRoom(stateMachine);
    }

    /**
     * 获得斗篷
     */
    void obtainCape(MarioStateMachine stateMachine){
        currentStatus.obtainCape(stateMachine);
    }

    /**
     * 获得火焰
     */
    void obtainFireFlower(MarioStateMachine stateMachine){
        currentStatus.obtainFireFlower(stateMachine);
    }

    /**
     * 遇到怪物
     */
    void meetMonster(MarioStateMachine stateMachine){
        currentStatus.meetMonster(stateMachine);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentStatus(Mario currentStatus) {
        this.currentStatus = currentStatus;
    }
}
