//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package leetcode.editor.cn;

/**
 * Java：寻找两个正序数组的中位数
 * <p>
 * 解题
 * <p>
 * - 时间复杂度：O(m+n)
 * - 空间复杂度：
 * <p>
 * - topics
 */
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int totalLength = m + n;

            // nums1、nums2下标指针 和 中位数
            int index1 = 0, index2 = 0, left = -1, right = -1;
            for (int i = 0; i <= totalLength / 2; i++) {
                left = right;
                // nums1数组没有到最后，且此时num1的数值小于num2位置的数值
                // 同时也要考虑num2数组越界的问题
                if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                    right = nums1[index1++];
                } else {
                    right = nums2[index2++];
                }
            }

            // 判断是奇数还是偶数
            // 如果是偶数，则中位数为（left + right）/ 2
            // 如果是奇数，则中位数为 right / 2
            return (totalLength % 2 == 0) ? (left + right) / 2.0 : right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}