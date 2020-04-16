package com.coderandyli.designpattern.chapter_08.section_64.case_01;

import com.coderandyli.designpattern.chapter_08.section_64.case_01.mariostatus.SmallMario;

/**
 * 超级玛丽状态机
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/30 下午5:44
 */
public class MarioStateMachine {
    private int score;
    private Mario currentStatus;

    public MarioStateMachine(int score) {
        this.score = score;
        this.currentStatus = new SmallMario(this);
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
    void obtainMushRoom(){
        currentStatus.obtainMushRoom();
    }

    /**
     * 获得斗篷
     */
    void obtainCape(){
        currentStatus.obtainCape();
    }

    /**
     * 获得火焰
     */
    void obtainFireFlower(){
        currentStatus.obtainFireFlower();
    }

    /**
     * 遇到怪物
     */
    void meetMonster(){
        currentStatus.meetMonster();
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
