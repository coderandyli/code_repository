package com.coderandyli.service;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;

import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2019-01-27
 */
@HttpApi(prefix = "http://localhost:20001/student")
public interface StudentService {

    @HttpReq("/list")
    List<Map<String, Object>> getStudentList();
}
