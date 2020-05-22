package com.coderandyli.jvm.chapter04;

import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-12-23
 */
public class OOMObject {
    private static final int _1MB = 1024 * 1024;
    public byte[] placeholder = new byte[64 * _1MB];
}
