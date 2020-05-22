package com.coderandyli.designpattern.chapter_07.section_50;

import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {


    public static void main(String[] args) {
        test2();
    }

    /**
     * 装饰者模式
     */
    public static void test2() {
        AbstractLunch lunch = new Lunch(),
                meat = new Meat(lunch),
        vegetables = new Vegetables(meat);
        System.out.println(vegetables.eat() + "A total of " + vegetables.cost() + "yuan");
    }

    @SneakyThrows
    public static void test1() {
        InputStream in = null, bin = null;
        try {
            in = new FileInputStream("/Users/lizhen/Desktop/test.txt");
            bin = new BufferedInputStream(in);
            byte[] data = new byte[128];
            int byteCount = 0;
            while ((byteCount = bin.read(data)) != -1) {
                System.out.println(new String(data, 0, byteCount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (bin != null) {
                bin.close();
            }
        }
    }
}
