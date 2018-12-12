package com.coderandyli.mongodbdemo.controller;

import com.coderandyli.mongodbdemo.entity.Ports;
import com.coderandyli.mongodbdemo.repository.PortsRepository;
import com.coderandyli.mongodbdemo.service.MongoPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lizhen on 2018-12-10
 */
@RestController
@RequestMapping("/prots")
public class MongoPortController {

    @Autowired
    private MongoPortService mongoPortService;

    @GetMapping("/{code}")
    public String findPortByCode(@PathVariable("code") String code){
        Ports port = mongoPortService.findPortsByCode(code);
        return port.toString();
    }

    @GetMapping("/all")
    public List<Ports> findAllPort(){
        return mongoPortService.findAllPorts();
    }
}
