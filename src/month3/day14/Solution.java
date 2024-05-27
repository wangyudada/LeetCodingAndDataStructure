package month3.day14;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * https://leetcode.cn/problems/combination-sum-iii/description/
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int k, int target, int index, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0 || tempList.size() >= k) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (tempList.size() <= k) {
                tempList.add(i);
            }
            dfs(k, target - i, i + 1, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }
}
