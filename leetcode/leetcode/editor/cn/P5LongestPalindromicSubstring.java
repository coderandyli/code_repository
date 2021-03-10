package leetcode.editor.cn;

/****************** 最长回文子串 ******************/

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abcbad"));

        System.out.println(solution.longestPalindrome("abccbad"));

        String str = "aaa";
        System.out.println(str.toCharArray().length);
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 中心扩散的思路
     * 示例："abcbad"
     * n = 6； 一共有 2n-1 个中心点，即：n 个单字符中心点；n-1 个双字符的中心点
     */
    class Solution {
        public String longestPalindrome(String s) {
            if (null == s || "".equals(s)) {
                return "";
            }

            char[] chars = s.toCharArray();
            int length = chars.length;
            int left, right, longestLength = Integer.MIN_VALUE;
            String longestPalindromeStr = null;

            // 以单个字符为中心扩散,
            for (int i = 0; i < length; i++) {
                left = right = i;
                while (left >= 0 && right < length && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                if ((right - left) >= longestLength) {
                    longestLength = right - left;
                    longestPalindromeStr = s.substring(left + 1, right);
                }
            }

            // 以双字符为中心扩散
            for (int i = 0; i < length - 1; i++) {
                left = i;
                right = i + 1;
                while (left >= 0 && right < length && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                if (right - left >= longestLength) {
                    longestLength = right - left;
                    longestPalindromeStr = s.substring(left + 1, right);
                }
            }
            return longestPalindromeStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}