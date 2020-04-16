package com.coderandyli.designpattern.chapter_08.section_64.case_01.mariostatus;

import com.coderandyli.designpattern.chapter_08.section_64.case_01.Mario;
import com.coderandyli.designpattern.chapter_08.section_64.case_01.MarioStateMachine;
import com.coderandyli.designpattern.chapter_08.section_64.case_01.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/31 上午10:28
 */
@Slf4j
public class CapeMario implements Mario {
    private MarioStateMachine stateMachine;

    public CapeMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public Status getName() {
        return Status.CAPE;
    }

    @Override
    public void obtainMushRoom() {
        // do nothing
    }

    @Override
    public void obtainCape() {
        // do nothing
    }

    @Override
    public void obtainFireFlower() {
        // do nothing
        log.info("class CapeMario, method obtainFireFlower, do nothing");
    }

    @Override
    public void meetMonster() {
        stateMachine.setScore(stateMachine.getScore() - 200);
        stateMachine.setCurrentStatus(new SmallMario(stateMachine));
    }
}
