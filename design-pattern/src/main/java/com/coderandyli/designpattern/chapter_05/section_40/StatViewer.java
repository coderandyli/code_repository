package com.coderandyli.designpattern.chapter_05.section_40;

import com.coderandyli.designpattern.chapter_05.section_40.model.RequestStat;

import java.util.Map;

public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
