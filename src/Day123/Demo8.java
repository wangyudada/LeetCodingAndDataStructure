package Day123;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 */
public class Demo8 {
    public static void main(String[] args) {
        int[] ints = {2, 2, 3, 4};
        System.out.println(triangleNumber(ints));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
//                这边赋为j是为了防止nums[0]=0的存在
                int k = j;
                while (right >= left) {
//                    二分法的中间是首尾相加除以2
                    int mid = (right + left) / 2;
//                    两边之和大于第三边，由于数组是递增的，则通过二分法找到最合适的中间值
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += k - j;
            }

        }
        return count;
    }
}
