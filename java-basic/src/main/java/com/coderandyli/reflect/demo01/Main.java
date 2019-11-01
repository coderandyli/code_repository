package com.coderandyli.reflect.demo01;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-10-30
 */
@Slf4j
public class Main {

    public static void main(String args[]) {
        test();
    }


    public static void test() {
        Map<String, String> enumMap = new HashMap<>();
        enumMap.put("UserType", "0");
        enumMap.put("SegmentStatus", "700");

        Class<?> aClass = null;
        Method getMeaning = null;
        Object[] enumConstants = null;
        try {
            for (Map.Entry<String, String> entry : enumMap.entrySet()) {
                if (!StringUtils.isEmpty(entry.getValue())) {
                    aClass = Class.forName("com.coderandyli.reflect.demo01." + entry.getKey() + "Enum");

                    String value = entry.getValue();
                    getMeaning = aClass.getDeclaredMethod("getMeaning", String.class);
                    enumConstants = aClass.getEnumConstants();
                    log.debug("enumConstants count = {}", enumConstants.length);
                    String invoke = (String)getMeaning.invoke(enumConstants[2], value);
                    log.debug("invoke = {}", invoke);

                    // 此处的处理，为了在查询的时候可以直接使用in语法，而不用转为list使用in
//                    enumMap.put(entry.getKey(), "(" + entry.getValue() + ")");
//                    log.debug("StringBuffer = {}", buffer);
                }
            }
        } catch (Exception e) {

        }
    }


}
