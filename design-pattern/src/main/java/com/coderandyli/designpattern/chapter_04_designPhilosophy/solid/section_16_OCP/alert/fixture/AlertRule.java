package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture;

/**
 * Created by lizhen on 2019-12-14
 */
public class AlertRule {

    public AlertRule getMatchedRule(String api){
        return new AlertRule();
    }

    /**
     * 允许tps最大请求时时间
     * @return
     */
    public long getMaxTps(){
        return 5;
    }

    /**
     * 允许最大报错数量
     * @return
     */
    public long getMaxErrorCount(){
        return 100;
    }

    /**
     * 允许tps最大超时时间
     * @return
     */
    public long getMaxTimeoutTps(){
        return 10;
    }

}
