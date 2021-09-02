package day20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * https://leetcode-cn.com/problems/permutations/
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            integers.add(num);
        }
        dfs(nums, ans, 0, integers);
        return ans;
    }

    public static void dfs(int[] nums, List<List<Integer>> ans, int idx, List<Integer> integers) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(integers));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            Collections.swap(integers, idx, i);
            dfs(nums, ans, idx + 1, integers);
            Collections.swap(integers, idx, i);
        }
    }
}
