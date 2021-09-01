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
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo {

    public static void main(String[] args) {
        int[] ints = {2, 5, 2, 1, 2};
        List<List<Integer>> lists = combinationSum2(ints, 5);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);

        List<Integer> selected = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        dfs(candidates, target, 0, selected, results);

        return results;
    }

    public static void dfs(int[] candidates, int target, int beginIndex, List<Integer> selected, List<List<Integer>> results) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            results.add(new ArrayList(selected));
            return;
        }

        for (int i = beginIndex; i < candidates.length; ++i) {
            // 使用 Integer
            // 避免调用 List 调用 remove(int index); 方法
            Integer candidate = candidates[i];

            // 做选择
            selected.add(candidate);

            dfs(candidates, target - candidate, i + 1, selected, results);

            // 撤销选择
            selected.remove(candidate);

            // 如果 candidates[i] == candidates[i + 1]，表示当前分支已经走过了
            // 因此要跳过
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
