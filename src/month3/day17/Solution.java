package month3.day17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    List<Integer> temp;

    /**
     * https://leetcode.cn/problems/subsets/description/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(0, nums);
        return res;
    }

    private void dfs(int index, int[] nums) {
        res.add(new ArrayList<>(temp));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
