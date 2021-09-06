package day22;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
//        这个数组一会用来去重
        boolean visited[] = new boolean[nums.length];
        dfs(nums, 0, visited, ans, selected);
        return ans;
    }

    public static void dfs(int[] nums, int idx, boolean[] visited, List<List<Integer>> ans, List<Integer> selected) {
        /*
        此处将组合问题看成一个树，每个递归是往树枝走深一步,每次for循环是往树层右边走一步,
        根据题意，每个树层的元素不能重复取
        递归每取个元素，则这个元素是一个子集，将子集加入到ans数组中
         */
        ans.add(new ArrayList<>(selected));
        for (int i = idx; i < nums.length; i++) {
//            当前一个树层的visited为false的时候，说明该元素被同一树层用过，则跳过
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
//            将visited参数赋为true，说明同一树枝上面，用过该元素
            visited[i] = true;
            selected.add(nums[i]);
            dfs(nums, i + 1, visited, ans, selected);
//            这边在每个for循环的结束将该树层的visited参数赋为false
            visited[i] = false;
            selected.remove(selected.size() - 1);
        }
    }
}
