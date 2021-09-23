package month1.day7;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class Demo {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
//        结果初始化
        int res = nums[0] + nums[1] + nums[2];
//        总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                sum = nums[start] + nums[end] + nums[i];
//                现在的距离和之前的距离
                int nowDis = Math.abs(target - sum);
                int lastDis = Math.abs(target - res);
                if (nowDis < lastDis) {
                    res = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                }
//                如果都不符合
                else {
                    return res;
                }
            }
        }
        return res;
    }
}
