package day20;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo3 {
    static boolean[] vis;

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        dfs(nums, 0, selected, ans);
        return ans;
    }

    public static void dfs(int[] nums, int idx, List<Integer> selected, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(selected));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            selected.add(nums[i]);
            vis[i] = true;
            dfs(nums, idx + 1, selected, ans);
            vis[i] = false;
            selected.remove(idx);
        }
    }
}
