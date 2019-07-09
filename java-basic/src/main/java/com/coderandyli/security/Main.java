package com.coderandyli.security;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-07-09
 */
public class Main {


    public static void main(String args[]) {
        System.out.println(test());
    }

    public static String test() {
        String jsonStr = "";
        try {
            FileReader fr = new FileReader("/Users/lizhen/Desktop/git/github/code_repository/java-basic/src/main/java/com/coderandyli/security/test_data.txt");//需要读取的文件路径
            BufferedReader br = new BufferedReader(fr);
            jsonStr = br.readLine();
            br.close();
            fr.close();     //关闭文件流
        } catch (IOException e) {
            System.out.println("指定文件不存在");//处理异常
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map = JSON.parseObject(jsonStr);
        return jsonStr;
    }
}
