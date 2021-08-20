package Day11;


/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */
public class Demo {
    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int lo = 0;
        int hi = 0;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                lo = i - 1;
                break;
            }
        }
        for (int i = length - 1; i > lo; i--) {
            if (nums[i] > nums[lo]) {
                hi = i;
                break;
            }
        }
        if (lo == 0 && hi == 0) {
            hi = length - 1;
            while (lo < hi) {
                swap(nums, lo, hi);
                lo++;
                hi--;
            }
        } else {
            swap(nums, lo, hi);
            hi = length - 1;
            while (lo + 1 < hi) {
                swap(nums, lo + 1, hi);
                lo++;
                hi--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int sto = nums[i];
        nums[i] = nums[j];
        nums[j] = sto;
    }
}
