package month3.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res;

    List<Integer> tmp;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    private void dfs(int index, int[] nums) {
        res.add(new ArrayList<>(tmp));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            dfs(i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
