package com.coderandyli.encryption;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/22 下午2:16
 */
public class Base64Utils {
    private static final String CHARSET_UTF8 = "UTF-8";

    /**
     * 编码
     * @param src
     *        the string to encode
     * @return
     */
    public static String encode(String src) {
        try {
            return Base64.getEncoder().encodeToString(src.getBytes(CHARSET_UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解码
     * @param src
     *        the string to decode
     * @return
     */
    public static String decode(String src) {
        byte[] decode = Base64.getDecoder().decode(src);
        try {
            return new String(decode, CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
