package com.coderandyli.openSourceFrameworkBugs.FastJson.bug;

import com.alibaba.fastjson.JSON;

/**
 * Created by lizhen on 2019-11-26
 *
 *  复现2689BUG
 *      https://github.com/alibaba/fastjson/issues/2689
 *   解决版本
 *      1.2.60
 */
public class BUG_2689 {

    public static void main(String args[]) {
        String DEATH_STRING = "{\"a\":\"\\x";
        Object parse = JSON.parse(DEATH_STRING);
        System.out.println(parse);
    }
}
