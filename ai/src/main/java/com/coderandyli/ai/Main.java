package com.coderandyli.ai;

import java.util.Scanner;

/**
 * Created by lizhen on 2018-12-15
 */
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str;
        while (true){
            str = scanner.next();
            str = str.replace("吗", "");
            str = str.replace("?","!");
            str = str.replace("？", "!");
            System.out.println(str);
            
        }
    }

}
