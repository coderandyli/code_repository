package com.coderandyli.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhen on 2019-02-22
 */
@Data
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private List<String> titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;
}
