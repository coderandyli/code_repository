package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture;

/**
 * Created by lizhen on 2019-12-14
 */
public class AlertRule {

    public AlertRule getMatchedRule(String api){
        return new AlertRule();
    }

    public long getMaxTps(){
        return 0;
    }

    public long getMaxErrorCount(){
        return 0;
    }

    public long getMaxTimeoutTps(){
        return 0;
    }

}
