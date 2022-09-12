//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 1808 👎 0

package editor.cn;
/**
 * Java：Z 字形变换
 *
 * 解题
 *  - 复杂度
 *      - 时间复杂度：
 *      - 空间复杂度：
 *
 *  - topics
 */
public class P6ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        // TO TEST
        String reuslt = solution.convert("PAYPALISHIRING", 3);
        System.out.println(reuslt);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        // 记录每行字符串
        StringBuilder[] stringLineArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringLineArr[i] = new StringBuilder();
        }

        int flag = 1; // 1: 往下走；-1: 往上走
        int currentLine = 0; // 当前行数
        for (int i = 0; i < s.length(); i++) {
            stringLineArr[currentLine].append(s.charAt(i));

            // 确认走向
            if (currentLine == 0) flag = 1;
            if (currentLine == numRows - 1)  flag = -1;

            currentLine += flag;
        }

        // 获取返回值
        StringBuilder reusltStr = new StringBuilder();
        for (int i = 0; i < stringLineArr.length; i++) {
            reusltStr.append(stringLineArr[i]);
        }

        return reusltStr.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}