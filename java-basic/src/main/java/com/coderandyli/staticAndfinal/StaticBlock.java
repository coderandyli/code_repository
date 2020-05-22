package com.coderandyli.staticAndfinal;

public class StaticBlock {
    static {
        System.out.println("this is a static code block");
    }

    public StaticBlock() {
        System.out.println("this is a contructor method");
    }


    public void test() {
        System.out.println("method test()");
    }

    public static void main(String[] args) {

    }
}
