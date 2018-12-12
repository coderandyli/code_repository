package com.coderandyli.mongodbdemo.service;

import com.coderandyli.mongodbdemo.entity.Ports;

import java.util.List;

/**
 * Created by lizhen on 2018-12-10
 */
public interface MongoPortService {

    Ports findPortsByCode(String code);

    List<Ports> findAllPorts();
}
