package com.coderandyli.RESTful.service;

import com.coderandyli.RESTful.entity.Zoo;
import com.coderandyli.RESTful.utils.ZooStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lizhen on 2019-08-31
 */
@Service
public class ZooService {

    private Map<Long, Zoo> dataMap = new ConcurrentHashMap<>(300, 1);
    private List<Zoo> dataList = new ArrayList<>();

    /**
     * 初始化数据
     */
    @PostConstruct
    private void init() {
        for (long i = 0; i < 10; i++) {
            Zoo zoo = new Zoo(i, "zoo" + i, "shanghai"+i, ZooStatus.normal);
            dataMap.put(i, zoo);
            dataList.add(zoo);
        }
    }


    public List<Zoo> findZoos() {
        return dataList;
    }

    public boolean createZoos(Zoo zoo) {
        dataList.add(zoo);
        return true;
    }

    public Zoo findZooById(String id) {
        Zoo zoo = dataMap.get(id);
        return zoo;
    }
}
