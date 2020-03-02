package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.case_03.handle;

import lombok.Data;

/**
 * Created by lizhen on 2019-12-14
 */
@Data
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
}
