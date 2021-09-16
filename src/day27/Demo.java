package day27;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 *
 * @author WangYu
 */
public class Demo {
    public static void main(String[] args) {
        int[] ints = {1};
        int targetSumWays = findTargetSumWays(ints, 1);
        System.out.println(targetSumWays);
    }

    static int count = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    public static void dfs(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(nums, target, idx + 1, sum + nums[idx]);
            dfs(nums, target, idx + 1, sum - nums[idx]);
        }
    }
}
