package month1.day13;

/**
 * 堆排序的Java实现
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64};
        int length = nums.length - 1;

        int beginIndex = (length - 1) / 2;
        for (int i = beginIndex; i >= 0; i--) {
            buildMaxHeap(nums, length, beginIndex);
        }

        for (int i = length; i >= 0; i--) {
            swap(nums, 0, i);
            buildMaxHeap(nums, i - 1, 0);
        }
    }

    //    建立大顶堆
    public static void buildMaxHeap(int[] nums, int length, int beginIndex) {
        int li = beginIndex * 2 + 1;
        int ri = li + 1;
        int max = li;

        if (li > length) {
            return;
        }

        if (ri <= length && nums[ri] > nums[li]) {
            max = ri;
        }
        if (nums[max] >= nums[beginIndex]) {
            swap(nums, beginIndex, max);
            buildMaxHeap(nums, length, max);
        }
    }

    public static void swap(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
