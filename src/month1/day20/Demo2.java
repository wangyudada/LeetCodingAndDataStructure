package month1.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 王宇
 */
public class Demo2 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(9, 45);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        dfs(ans, results, k, 1, n);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> results, int k, int idx, int n) {
        if (results.size() == k && n == 0) {
            ans.add(new ArrayList<>(results));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            results.add(i);
            dfs(ans, results, k, i + 1, n - i);
            results.remove(results.size() - 1);
        }
    }
}
