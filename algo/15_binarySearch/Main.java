/**
 * Created by lizhen on 2019-06-16
 *
 * 二分查找
 */
public class Main {


    /**
     *  二分查找的递归实现
     * @param a
     * @param n
     * @param val
     * @return
     */
    public int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }



//    /**
//     * 二分查找的非递归实现方式
//     * @param a 数组
//     * @param n
//     * @param value
//     * @return
//     */
//    public int bsearch(int[] a, int n, int value) {
//        int low = 0;
//        int high = n - 1;
//
//        while (low <= high) {
//            // int mid = (low + high) / 2; // 二者之和有可能溢出
//            // int mid = low + (high - low) / 2;
//            int mid = low + (high - low) >> 1; // 位运算，计算机处理快
//            if (a[mid] == value) {
//                return mid;
//            } else if (a[mid] < value) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//
//        return -1;
//    }

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6};

        int bsearch = new Main().bsearch(array, array.length, 2);
        System.out.println(bsearch);
    }

}
