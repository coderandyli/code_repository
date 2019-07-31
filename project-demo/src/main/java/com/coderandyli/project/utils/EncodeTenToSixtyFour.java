package com.coderandyli.project.utils;

import java.util.Stack;

/**
 * Created by lizhen on 2019-07-29
 * 10进制与64进制转换
 * https://my.oschina.net/TJALS/blog/841857
 */
public class EncodeTenToSixtyFour {

    public static void main(String[] args) {
        System.out.println("10进制与64进制互转类");
        System.out.println(encode(10000000));
        System.out.println(decode(encode(10000)));
    }

    // 打乱编码,必须使用本集合进行解码
    public static final char[] array = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h',
            'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '8', '5', '2', '7', '3', '6', '4', '0', '9', '1', 'Q',
            'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M', '+', '-'};

    /**
     * 编码,从10进制转换到64进制
     *
     * @param number long类型的10进制数,该数必须大于0
     * @return string类型的64进制数
     */
    public static String encode(long number) {
        Long rest = number;
        // 创建栈
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest >= 1) {
            // 进栈,
            // 也可以使用(rest - (rest / 64) * 64)作为求余算法
            stack.add(array[new Long(rest % 64).intValue()]);
            rest = rest / 64;
        }
        for (; !stack.isEmpty(); ) {
            // 出栈
            result.append(stack.pop());
        }
        return result.toString();

    }

    /**
     * 解码,从64进制解码到10进制
     *
     * @param str string类型的64进制数A-Z,a-z,0-9,+,-
     * @return long类型的10进制数
     */
    public static long decode(String str) {
        // 倍数
        int multiple = 1;
        long result = 0;
        Character c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(str.length() - i - 1);
            result += decodeChar(c) * multiple;
            multiple = multiple * 64;
        }
        return result;
    }

    /**
     * 比对数组,得到字符对应的值
     *
     * @param c 64位字符
     * @return
     */
    private static int decodeChar(Character c) {
        for (int i = 0; i < array.length; i++) {
            if (c == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
