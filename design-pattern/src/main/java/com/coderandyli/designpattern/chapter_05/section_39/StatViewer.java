package com.coderandyli.designpattern.chapter_05.section_39;

import com.coderandyli.designpattern.chapter_05.section_39.model.RequestStat;

import java.util.Map;

public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
