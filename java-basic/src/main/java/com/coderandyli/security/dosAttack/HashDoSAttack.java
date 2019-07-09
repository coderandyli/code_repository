package com.coderandyli.security.dosAttack;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2019-07-09
 * <p>
 * DoS(Denial of Service)攻击之 hash Collision（哈希碰撞攻击）原理
 */
public class HashDoSAttack {

    public static void main(String args[]) {
        System.out.println(test01());
    }

    public static String test01() {
        String jsonStr = "";
        try {
            /**
             * 当 test_data.txt 文件中的数据足够大时，CPU使用率就会迅速上升，从而达到DoS的攻击的效果
             */
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

    /**
     * 依靠相应语言的hashtable/hashmap实现过程（request多为此结构），当不同的key存入时如果hash值相等则以链表方式连接在前面。
     * 此漏洞利用碰撞相同的hash值得到一个长链表， 重新get时，map的计算过程会将时间复杂度巨增，原来一个简单的过程将变成一个很费
     * cpu的过程。 常见的服务器会将用户post的数据保存在hashmap中. 而向hashmap中插入n对元素的时间复杂度大约是O(n), 但如果精心
     * 构造key使得每个key的hash值相同(也就是产生了碰撞),则时间复杂度会恶化到O(n^2),导致消耗大量的CPU时间.
     * ---------------------
     * 作者：放逐的信仰
     * 来源：CSDN
     * 原文：https://blog.csdn.net/qq_29923439/article/details/77983606
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     */
    @Test
    public void test02() {

        HashMap<App, String> hash = new HashMap<App, String>();
        Long start = System.currentTimeMillis();
        for (Integer i = 0; i < 65536; i++) {
            App app = new App();
            app.setId(100);
            hash.put(app, i.toString());
        }
        App app2 = new App();
        app2.setId(100);
        hash.get(app2);
        Long end = System.currentTimeMillis();
        System.out.println("第一种方式" + (end - start) / 1000);//33

        HashMap<App, String> hash2 = new HashMap<App, String>();
        Long start2 = System.currentTimeMillis();
        for (Integer i = 0; i < 65536; i++) {
            App app = new App();
            app.setId(i);
            hash2.put(app, i.toString());
        }
        App app3 = new App();
        app3.setId(100);
        hash2.get(app3);
        Long end2 = System.currentTimeMillis();
        System.out.println("第2种方式" + (end2 - start2) / 1000);
    }


}
