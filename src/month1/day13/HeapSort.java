package month1.day13;

import java.util.Arrays;

/**
 * 堆排序的Java实现
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64};
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
//            建立大顶堆
            buildMaxHeap(a, length - 1 - i);
            swap(a, 0, length - 1 - i);
            System.out.println(Arrays.toString(a));
        }
    }

    //    建立大顶堆
    public static void buildMaxHeap(int[] a, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
//            k保存正在判断的节点
            int k = i;
            while ((k * 2 + 1) <= lastIndex) {
//                k节点的左子节点
                int biggerIndex = 2 * k + 1;
//                如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
//                    如果右子节点的值较大
                    if (a[biggerIndex] < a[biggerIndex + 1]) {
//                        变更biggerIndex的值，只记录较大子节点的索引
                        biggerIndex++;
                    }
                }
//                如果有子节点比k节点的值大，则交换两个节点的值，保证k节点的值永远比儿女节点大
                if (a[k] < a[biggerIndex]) {
                    swap(a, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
