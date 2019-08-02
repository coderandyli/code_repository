package com.coderandyli.leetcode;

/**
 * Created by lizhen on 2019-07-22
 */
public class LeetCode {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    //    class Solution {
    public boolean isValid(String s) {
        ArrayStack st = new ArrayStack(s.length());
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    st.push(s.charAt(i));
                    break;
                case ')':
                    if (st.empty() || st.top() != '(') return false;
                    st.pop();
                    break;
                case ']':
                    if (st.empty() || st.top() != '[') return false;
                    st.pop();
                    break;
                case '}':
                    if (st.empty() || st.top() != '{') return false;
                    st.pop();
                    break;
            }
        }
        return st.empty();
    }

    /**
     * 顺序栈
     */
    public class ArrayStack {
        private char[] items; //数组
        private int count; //栈中元素个数
        private int n; // 栈的大小

        public ArrayStack(int capacity) {
            this.items = new char[capacity];
            this.n = capacity;
            this.count = 0;
        }

        /**
         * 入栈操作
         *
         * @param item
         */
        public boolean push(char item) {
            // 将item放到下标为count的位置，并且count+1
            items[count] = item;
            count++;
            return true;
        }

        /**
         * 出栈
         */
        public char pop() {
            char temp = items[count - 1];
            count--;
            return temp;
        }

        public Boolean empty() {
            return count == 0;
        }

        public char top() {
            return items[count - 1];
        }
    }

}

