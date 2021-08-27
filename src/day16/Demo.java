package day16;

import java.util.ArrayList;

/**
 * 基数排序的Java实现
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list[] = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new ArrayList<Integer>();
        }
        int[] num = {7, 14, 9, 333, 201, 1, 88, 6, 57, 10, 56, 74, 36, 234, 456};
        long startTime = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        //第一次遍历获得序列中的最大值
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        int k = 1;
        for (int i = 0; i < String.valueOf(max).length(); i++) {
            split(list, num, k);
            System.out.println("第" + (i + 1) + "次排序");
            merge(list, num);
            k = k * 10;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    //    将所有的数组合并成原来的数组
    public static void merge(ArrayList<Integer> list[], int num[]) {
        int k = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                for (int j = 0; j < list[i].size(); j++) {
                    num[k++] = list[i].get(j);
                    System.out.println(num[k - 1] + " ");
                }
            }
            list[i].clear();
        }
        System.out.println();
    }

    //    将所有的元素分散到各个链表中
    public static void split(ArrayList<Integer> list[], int num[], int k) {
        for (int i = 0; i < num.length; i++) {
//            这边把k模10是为了取个位数，十位数等等
            list[num[i] / k % 10].add(num[i]);
        }
        System.out.println("------------------------");
        System.out.println("个位数开始，第" + String.valueOf(k).length() + "位排序结果");
        for (int i = 0; i < 10; i++) {
            System.out.println(String.valueOf(k).length() + "号位，数值为" + i + "的链表结果:" + list[i]);
        }
    }
}
