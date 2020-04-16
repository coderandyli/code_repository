package com.coderandyli.designpattern.chapter_08.section_64.case_02.mariostatus;

import com.coderandyli.designpattern.chapter_08.section_64.case_02.MarioStateMachine;
import com.coderandyli.designpattern.chapter_08.section_64.case_02.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/31 上午10:28
 */
@Slf4j
public class CapeMario extends AbstractMario {

    private static final CapeMario instance = new CapeMario();

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public Status getName() {
        return Status.CAPE;
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        // do nothing
        log.info("class CapeMario, method obtainFireFlower, do nothing");
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() - 200);
        stateMachine.setCurrentStatus(SmallMario.getInstance());
    }
}
