package month3.day13;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * https://leetcode.cn/problems/combination-sum-ii/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        return result;
    }

    public void dfs(int[] candidates,int target,ArrayList<List<Integer>> result, ArrayList<Integer> tempList,int index){
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int temp = candidates[i];
            tempList.add(candidates[i]);
            if (i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            dfs(candidates,target-temp,result,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
