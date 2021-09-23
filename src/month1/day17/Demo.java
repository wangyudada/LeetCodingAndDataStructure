package month1.day17;

import java.util.Arrays;

/**
 * 二分查找的Java实现
 */
public class Demo {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 5, 6};
        System.out.println(sort(ints, 3, 0, 4));
    }

    /**
     * 非递归实现
     *
     * @param array
     * @param a
     * @return mid
     */
    public static int biSearch(int[] array, int a) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] > a) {
                right--;
            } else {
                left++;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param array
     * @param a
     * @param left
     * @param right
     * @return mid
     */
    public static int sort(int[] array, int a, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == a) {
            return mid + 1;
        } else if (array[mid] < a) {
            return sort(array, a, mid + 1, right);
        } else if (array[mid] > a) {
            return sort(array, a, left, mid - 1);
        }
        return -1;
    }
}
