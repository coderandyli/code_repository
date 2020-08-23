//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;

/**
 * Java：两数相加
 * <p>
 * 解题
 * - 复杂度
 * - 时间复杂度：
 * - 空间复杂度：
 * <p>
 * - topics
 */
public class P2AddTwoNumbers {
//    public static void main(String[] args) {
//        Solution solution = new P2AddTwoNumbers().new Solution();
//        // TO TEST
//
//        // l3 -> l2 -> l1
//        ListNode l1 = new ListNode(3);
//        ListNode l2 = new ListNode(4, l1);
//        ListNode l3 = new ListNode(2, l2);
//
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(6, l4);
//        ListNode l6 = new ListNode(5, l5);
//
//        ListNode listNode = solution.addTwoNumbers(l3, l6);
//
//        print(listNode);
//
//    }
//
//    public static void print(ListNode listNode) {
//        int val = listNode.getVal();
//        System.out.println(val);
//        ListNode next = listNode.getNext();
//        if (next != null) {
//            print(next);
//        }
//    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int val1 = l1.val;
            ListNode next1 = l1.next;

            int val2 = l2.val;
            ListNode next2 = l2.next;

            // 判断是否需要进一
            int newValue = val1 + val2;
            int carryBit = 0;
            if (newValue >= 10) {
                carryBit = 1;
                newValue = newValue % 10;
            }

            ListNode listNode = new ListNode(newValue);
            process(next1, next2, listNode, carryBit);

            return listNode;
        }

        void process(ListNode l1, ListNode l2, ListNode listNode, int carryBit) {
            if (l1 == null && l2 == null) {
                return;
            }

            int val1 = (l1 == null) ? 0 : l1.val;
            ListNode next1 = (l1 == null) ? null : l1.next;

            int val2 = (l2 == null) ? 0 : l2.val;
            ListNode next2 = (l2 == null) ? null : l2.next;

            // 判断是否需要进一
            int newValue = val1 + val2 + carryBit;
            int carry = 0;
            if (newValue >= 10) {
                carry = 1;
                newValue = newValue % 10;
            }

            ListNode listNode2 = new ListNode(newValue);
            listNode.next = listNode2;
            process(next1, next2, listNode2, carry);
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }
    }



//leetcode submit region end(Prohibit modification and deletion)

}