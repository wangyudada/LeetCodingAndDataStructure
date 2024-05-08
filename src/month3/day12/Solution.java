package month3.day12;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * https://leetcode.cn/problems/combination-sum/
     *  示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> inners = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(candidates,target,result,inners,0);
        return result;
    }

    public void dfs(int[] candidates, int target, ArrayList<List<Integer>> result, ArrayList<Integer> inners, int index){
        if (target == 0){
            result.add(new ArrayList<>(inners));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            inners.add(candidate);
            dfs(candidates,target-candidate,result,inners, i);
            inners.remove(inners.size()-1);
        }
    }
}