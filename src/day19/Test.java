package day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [[1,1,6],[1,2,5],[1,7],[2,6]]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [[1,2,2],[5]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author WangYu
 */
public class Test {
    public static void main(String[] args) {
        int[] ints = {2, 5, 2, 1, 2};
        List<List<Integer>> lists = combinationSum2(ints, 5);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        List<Integer> selected = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[candidates.length];
        dfs(candidates, target, flag, 0, 0, ans, selected);
        return ans;
    }

    public static void dfs(int[] candidates, int target, boolean[] flag, int idx, int sum, List<List<Integer>> ans, List<Integer> selected) {
        if (sum == target) {
            ans.add(new ArrayList<>(selected));
            return;
        }
        if (idx > candidates.length) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum = sum + candidates[i];
            selected.add(candidates[i]);
            dfs(candidates, target, flag, i + 1, sum, ans, selected);
            sum = sum - candidates[i];
            flag[i] = false;
            selected.remove(selected.size() - 1);
        }
    }
}
