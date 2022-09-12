# 最大回文子串

## 解法一：中心扩散
- 根据中心扩散的思想解题，扩散点可以分为单字符扩散点、双字符扩散点。
>> 假如字符串长度为n，单字符扩散点有n个，双字符扩散点有n-1个
```
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
```
- 时间复杂度：O(n)
- 空间复杂度：O(1)

# 解法二：动态规划
