package month1.day29;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 */
public class Demo {

    ArrayList<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> selected = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int idx) {
        if (selected.size() > 1) {
            ans.add(new ArrayList<>(selected));
        }
        int[] used = new int[201];
        for (int i = idx; i < nums.length; i++) {
            if (!selected.isEmpty() && nums[i] < selected.get(selected.size() - 1) || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            selected.add(nums[i]);
            dfs(nums, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
