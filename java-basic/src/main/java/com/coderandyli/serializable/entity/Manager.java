package com.coderandyli.serializable.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lizhen on 2019-03-09
 */
@Data
public class Manager extends Position implements Serializable {

    private static final long serialVersionUID = -5526828326547193889L;
}
