# 方法一：将两个数组合并成一个大的数组，大数组的中位数即为所求结果
- 时间复杂度：O(m+n)
- 空间复杂度：O(m+n)

# 方法二： 不合并数组，采用双指针的方式
- 时间复杂度为: O(m+n)
- 空间复杂度：O(1) （不需要额外空间）

```$xslt
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int totalLength = m + n;

            // nums1、nums2下标指针 和 中位数
            int index1 = 0, index2 = 0, left = -1, right = -1;
            for (int i = 0; i <= totalLength / 2; i++) {
                // 防止数组越界(如果出现越界，将其对应的val值设为最大，已满足后续逻辑)
                int val1 = (m >= index1 + 1) ? nums1[index1] : Integer.MAX_VALUE;
                int val2 = (n >= index2 + 1) ? nums2[index2] : Integer.MAX_VALUE;

                if (val1 < val2) {
                    index1++;
                    if ((totalLength / 2 - 1) == i) left = val1;
                    if (totalLength / 2 == i) right = val1;
                } else {
                    index2++;
                    if (totalLength / 2 - 1 == i) left = val2;
                    if (totalLength / 2 == i) right = val2;
                }
            }

            // 是否有余数(判断是奇数还是偶数)
            return (totalLength % 2 == 0) ? (left + right) / 2.0 : right;
        }
    }
```
代码优化
```$xslt
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

            // 是否有余数(判断是奇数还是偶数)
            return (totalLength % 2 == 0) ? (left + right) / 2.0 : right;
        }
    }
```


# 方法三：通过二分查找降低查询时间复杂度
- TODO: 待编写代码
