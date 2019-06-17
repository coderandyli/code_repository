/**
 * Created by lizhen on 2019-06-17
 * 二分查找变体 （数据集合中存在重复数据）
 */
public class VariantBSearch {

    public static void main(String args[]) {
        int[] a2 = {1, 2, 3, 4, 5, 5, 5, 6, 7};

        int[] a1 = {1, 2, 3, 4, 4, 4, 4, 6, 7};

        int index = new VariantBSearch().bsearch04(a1, a1.length, 5);
        System.out.println(index);
    }

    // 查找最后一个小于等于给定值的元素
    public int bsearch04(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] <= value) {
                if (mid == (n - 1) || a[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素
    public int bsearch03(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || (a[mid - 1] < value))
                    return mid;
                else
                    high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    // 查找最后一个值等于给定值的元素
    public int bsearch02(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else { // 已找到
                if (mid == (n - 1) || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // 查找第一个值等于给定值的元素
    public int bsearch01(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else { // 已找到
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
