package com.coderandyli.controller;

import com.coderandyli.service.StudentService;
import com.github.dadiyang.httpinvoker.HttpApiProxyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2019-01-27
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService service = new HttpApiProxyFactory().getProxy(StudentService.class);
    @GetMapping("/list")
    public List<Map<String, Object>> getStudentList() {
        return service.getStudentList();
    }
}
