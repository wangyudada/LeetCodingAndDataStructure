package month3.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * https://leetcode.cn/problems/permutations/description/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = Arrays.asList(new Integer[nums.length]);
        boolean[] onPath = new boolean[nums.length];
        dfs(result, nums, 0, temp, onPath);
        return result;
    }

    private void dfs(ArrayList<List<Integer>> result, int[] nums, int index, List<Integer> temp, boolean[] onPath) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!onPath[i]) {
                temp.set(index, nums[i]);
                onPath[i] = true;
                dfs(result, nums, index + 1, temp, onPath);
                onPath[i] = false;
            }
        }
    }
}
