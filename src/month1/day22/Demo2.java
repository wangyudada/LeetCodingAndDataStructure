package month1.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * @author WangYu
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> subsets = subsets(ints);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
        dfs(0, ans, selected, nums);
        return ans;
    }

    public static void dfs(int idx, List<List<Integer>> ans, List<Integer> selected, int[] nums) {
        ans.add(new ArrayList<>(selected));
        if (idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            selected.add(nums[i]);
            dfs(i + 1, ans, selected, nums);
            selected.remove(selected.size() - 1);
        }
    }
}
