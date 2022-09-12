# 方法一：暴力法
- 双层for循环    
```
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                // 从i + 1开始，避免重复
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) return new int[]{i, j};
                }
            }
            return new int[]{0, 0};
        }
    }
```
## 复杂度分析
- 时间复杂度：O(n^2)
    - 对于一个元素，我们需要遍历其余的元素，复杂度为O(n)，因此其时间复杂度为O(n^2)
- 空间复杂度: O(1)

# 方法二：借助hash表
```$xslt
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            /**
             * 数组中元素作为key值，元素下标作为value值
             */
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                int residue = target - nums[i];
                if (map.containsKey(residue)) return new int[]{map.get(residue), i};
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
```
## 复杂度分析
- 时间复杂度：O(n)
- 空间复杂度: O(n)