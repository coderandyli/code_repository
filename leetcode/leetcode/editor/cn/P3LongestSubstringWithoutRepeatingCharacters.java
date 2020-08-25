//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Java：无重复字符的最长子串
 * <p>
 * 解题
 * - 复杂度
 *      - 时间复杂度： O(n)
 *      - 空间复杂度：
 * <p>
 * - topics
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，判断是否重复出现过
            Set<Character> occ = new HashSet<Character>();
            int length = s.length();

            int rk = -1, ans = 0;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    // 左指针右移一位，删除前一位数据
                    occ.remove(s.charAt(i - 1));
                }

                while (rk + 1 < length && !occ.contains(s.charAt(rk + 1))) {
                    // 移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}