package com.coderandyli.designpattern.chapter_05.section_39.viewer;

import com.coderandyli.designpattern.chapter_05.section_39.StatViewer;
import com.coderandyli.designpattern.chapter_05.section_39.model.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
