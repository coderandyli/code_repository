package com.coderandyli.mongodbdemo.repository;

import com.coderandyli.mongodbdemo.entity.Ports;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by lizhen on 2018-12-10
 */
public interface PortsRepository extends MongoRepository<Ports, String> {
    /**
     * 根据country查询
     */
    @Query("{'country':?0}")
    List<Ports> findPortsBycountry(ObjectId country);

    /**
     * 查找添加的 port
     *
     * @return
     */
    @Query("{'isAdd':true}")
    List<Ports> findIsAddPorts();

    /**
     * 通过name查询
     *
     * @return
     */
    Ports findByName();

    /**
     * 通过Code查询
     *
     * @return
     */
    Ports findByCode(String code);
}
