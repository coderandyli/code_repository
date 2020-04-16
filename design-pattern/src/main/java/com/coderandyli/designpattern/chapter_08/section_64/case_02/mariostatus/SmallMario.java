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
public class SmallMario extends AbstractMario {
    private static final SmallMario instance = new SmallMario();

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public Status getName() {
        return Status.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 100);
        stateMachine.setCurrentStatus(SuperMario.getInstance());
        log.info("exec obtainMushRoom");
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 200);
        stateMachine.setCurrentStatus(SuperMario.getInstance());
        log.info("exec obtainCape");
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 300);
        stateMachine.setCurrentStatus(SuperMario.getInstance());
        log.info("exec obtainFireFlower");
    }
}
