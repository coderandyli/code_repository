package com.coderandyli.designpattern.chapter_06.section_46;

public class Main {

    public static void main(String[] args) {
        ResourcePoolConfig resourcePoolConfig = new ResourcePoolConfig.Builder()
                .setName("李振")
                .setMaxTotal(10)
                .setMaxIdle(10)
                .setMinIdle(9)
                .build();
        System.out.println(resourcePoolConfig);
    }
}
