package com.coderandyli.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhen on 2019-10-31
 */
public class Test {

    public static void main(String args[]) {

//        GenericClass<String> genericClass = new GenericClass<>("类泛型测试");
//        System.out.println(genericClass.getData());

        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you", "你好吗？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you"));
    }
    
    /**
     * =============================================================================
     * =========          Overload test for generics            =========
     * =============================================================================
     */

    public void method(List<String> list){

    }

//    public void method(List<Integer> list){
//
//    }

}
