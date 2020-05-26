package com.coderandyli.encryption;

import com.google.common.base.Joiner;

import java.util.*;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/22 下午2:06
 */
public class Base64Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("111", "222", "333", "444");

        List<Object> objects = Collections.emptyList();
        String str = Joiner.on(",").join(list);

        // 编码
        String encode = Base64Utils.encode(str);
        System.out.println(encode);

        // 解码
        String decode = Base64Utils.decode(encode);
        System.out.println(decode);
    }


}
