package com.coderandyli.mongodbdemo.service.impl;

import com.coderandyli.mongodbdemo.entity.Ports;
import com.coderandyli.mongodbdemo.repository.PortsRepository;
import com.coderandyli.mongodbdemo.service.MongoPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lizhen on 2018-12-10
 */
@Service
public class MongoPortServiceImpl implements MongoPortService {

    @Autowired
    private PortsRepository portsRepository;

    @Override
    public Ports findPortsByCode(String code) {
        return portsRepository.findByCode(code);
    }

    @Override
    public List<Ports> findAllPorts() {
        return portsRepository.findAll();
    }
}
