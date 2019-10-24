package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/****************** 猜数字游戏 ******************/

//你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。 
//
// 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。 
//
// 请注意秘密数字和朋友的猜测数都可能含有重复数字。 
//
// 示例 1: 
//
// 输入: secret = "1807", guess = "7810"
//
//输出: "1A3B"
//
//解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。 
//
// 示例 2: 
//
// 输入: secret = "1123", guess = "0111"
//
//输出: "1A1B"
//
//解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。 
//
// 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。 
// Related Topics 哈希表

public class P299BullsAndCows {
    public static void main(String[] args) {
        Solution solution = new P299BullsAndCows().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getHint(String secret, String guess) {
            char[] secretChars = secret.toCharArray(), guessChars = guess.toCharArray();
            int bullsCount = 0, cowsCount = 0;

            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            List<Character> list = new ArrayList<Character>();
            for (int i = 0; i < secretChars.length; i++) {
                char secretChar = secretChars[i], guessChar = guessChars[i];
                if (secretChar == guessChar) { // 符合公牛
                    bullsCount++;
                } else { // 非公牛，用数组记录guessChar；用map记录secretChar及其出现的次数；
                    list.add(guessChar);
                    if (map.containsKey(secretChar)) {
                        map.put(secretChar, map.get(secretChar) + 1);
                    } else {
                        map.put(secretChar, 1);
                    }
                }
            }

            // 遍历，求奶牛数量
            for (Character character : list) {
                if (map.containsKey(character)) {
                    cowsCount++;
                    if (map.get(character) > 1) {
                        map.put(character, map.get(character) - 1);
                    } else {
                        map.remove(character);
                    }
                }
            }
            return bullsCount + "A" + cowsCount + "B";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}