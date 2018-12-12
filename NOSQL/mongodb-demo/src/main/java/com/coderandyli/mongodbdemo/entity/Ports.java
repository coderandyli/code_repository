package com.coderandyli.mongodbdemo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2018-12-10
 */
@Document(collection = "ports") //collection指定名字，不指定为类名
@Data
public class Ports {

    private String id;

    private String name;

    private String code;

    private String country;

    private Date dateCreate;

    private Date dateUpdate;

    private Date dateDelete;

    private String defaultTerminal;

    private String description;

    private Boolean isAdd;
}
