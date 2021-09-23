package month1.day11;

/**
 * 希尔排序
 * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。
 * 先在各组内进行直接插入排序；然后，取第二个增量d2
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("排序之前：");
        for (int i : a
        ) {
            System.out.print(i + ",");
        }
        int length = a.length;
        while (true) {
//            初始增量，意味着整个数组被分为6组分别为[49,27],[38,49]等等
            length = length / 2;
//            对六组分别进行插入排序
            for (int i = 0; i < length; i++) {
                for (int j = i + length; j < a.length; j = j + length) {
                    int temp = a[j];
                    int m;
                    for (m = j - length; m >= 0 && a[m] > temp; m = m - length) {
                        a[m + length] = a[m];
                    }
                    a[m + length] = temp;
                }
            }
            if (length == 1) {
                break;
            }
        }
        System.out.println("排序之后：");
        for (int i : a
        ) {
            System.out.print(i + ",");
        }
    }
}
