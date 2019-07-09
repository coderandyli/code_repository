package com.coderandyli.algo;

import org.springframework.util.DigestUtils;

/**
 * Created by lizhen on 2019-05-04
 */
public class Main {

    public static void main(String args[]) {
        String s = DigestUtils.md5DigestAsHex("lizhenADDSK".getBytes());
        System.out.println(s);
    }
}
