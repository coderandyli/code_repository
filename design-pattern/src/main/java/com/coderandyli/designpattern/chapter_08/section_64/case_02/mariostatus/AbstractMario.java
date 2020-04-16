package com.coderandyli.designpattern.chapter_08.section_64.case_02.mariostatus;

import com.coderandyli.designpattern.chapter_08.section_64.case_02.Mario;
import com.coderandyli.designpattern.chapter_08.section_64.case_02.MarioStateMachine;
import com.coderandyli.designpattern.chapter_08.section_64.case_02.Status;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/31 下午3:37
 */
public class AbstractMario implements Mario {
    @Override
    public Status getName() {
        return null;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {

    }
}
