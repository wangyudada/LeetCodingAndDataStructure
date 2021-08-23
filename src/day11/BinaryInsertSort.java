package day11;

/**
 * 二分法插入排序
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        System.out.println("排序之前：");
        for (int i : a
        ) {
            System.out.print(i + ",");
        }
        sort(a);
        System.out.println("排序之后：");
        for (int i : a
        ) {
            System.out.print(i + ",");
        }
    }

    //    二分法排序，这边走debug就可以看通
    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int left = 0;
            int right = i - 1;
            int mid = 0;
            int temp = a[i];
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            if (left != i) {
                a[left] = temp;
            }
        }
    }
}
