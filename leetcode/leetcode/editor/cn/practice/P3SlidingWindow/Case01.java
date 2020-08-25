package leetcode.editor.cn.practice.P3SlidingWindow;

/**
 * 给定一个整数数组，计算长度为 'k' 的连续子数组的最大总和。
 * <p>
 * 输入：arr [] = {100,200,300,400}
 * k = 2
 * <p>
 * 输出：700
 * <p>
 * 解释：300 + 400 = 700
 * <p>
 * 解题
 * - 滑动窗口
 */
public class Case01 {
    private int[] arr = {100, 200, 300, 400, 1000};
    private int length = arr.length;
    private int k = 2;

    public int maxSum() {
        if (length < k) return -1;

        // 计算第一个窗口的值
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        for (int i = k; i < length; i++) {
            // 新窗口 = 上一个窗口 + 新进入窗口的值 - 滑出窗口的值
            int sum = maxSum + arr[i] - arr[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Case01 case01 = new Case01();
        int i = case01.maxSum();
        System.out.println(i);
    }

}
