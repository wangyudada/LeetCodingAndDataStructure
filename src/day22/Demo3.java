package day22;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 *
 * @author WangYu
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(ints);
        System.out.println(lists);
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        dfs(nums, 0, visited, ans, selected);
        return ans;
    }

    public static void dfs(int[] nums, int idx, boolean[] visited, List<List<Integer>> ans, List<Integer> selected) {
        ans.add(new ArrayList<>(selected));
        for (int i = idx; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            selected.add(nums[i]);
            dfs(nums, i + 1, visited, ans, selected);
            visited[i] = false;
            selected.remove(selected.size() - 1);
        }
    }
}
