package com.coderandyli.designpattern.chapter_08.section_64.case_02.mariostatus;

import com.coderandyli.designpattern.chapter_08.section_64.case_02.MarioStateMachine;
import com.coderandyli.designpattern.chapter_08.section_64.case_02.Status;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/31 上午10:28
 */
public class FireMario extends AbstractMario {

    private static final FireMario instance = new FireMario();

    public static FireMario getInstance() {
        return instance;
    }

    @Override
    public Status getName() {
        return Status.FIRE;
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() - 300);
        stateMachine.setCurrentStatus(SmallMario.getInstance());
    }
}
