# 方法一：将两个数组合并成一个大的数组，大数组的中位数即为所求结果
- 时间复杂度：O(m+n)
- 空间复杂度：O(m+n)

# 方法二： 不合并数组，采用双指针的方式
- 时间复杂度为: O(m+n)
- 空间复杂度：O(1) （不需要额外空间）
- 
```$xslt
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int totalLength = m + n;
            // 是否有余数(判断是奇数还是偶数)
            boolean ifRemainder = (totalLength % 2 == 0);

            // nums1、nums2下标指针 和 中位数
            int index1 = 0, index2 = 0, median1 = 0, median2 = 0;
            for (int i = 0; i < totalLength / 2 + 1; i++) {
                // 防止数组越界(如果出现越界，将其对应的val值设为最大，已满足后续逻辑)
                int val1 = (m >= index1 + 1) ? nums1[index1] : Integer.MAX_VALUE;
                int val2 = (n >= index2 + 1) ? nums2[index2] : Integer.MAX_VALUE;

                if (val1 < val2) {
                    index1++;
                    if ((totalLength / 2 - 1) == i) median1 = val1;
                    if (totalLength / 2 == i) median2 = val1;
                } else {
                    index2++;
                    if (totalLength / 2 - 1 == i) median1 = val2;
                    if (totalLength / 2 == i) median2 = val2;
                }
            }
            return ifRemainder ? (double) (median1 + median2) / 2 : median2;
        }
    }
```

# 方法三：通过二分查找降低查询时间复杂度
