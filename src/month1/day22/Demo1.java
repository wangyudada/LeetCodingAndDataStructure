package month1.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author WangYu
 */
public class Demo1 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> com = new ArrayList<>();
        dfs(ans, com, n, k, 1);
        return ans;
    }

//    这边把需求看成一个宽度为n，深度为k的树
    public static void dfs(List<List<Integer>> ans, List<Integer> com, int n, int k, int idx) {
//        回溯达到了叶子节点
        if (com.size() == k) {
            ans.add(new ArrayList<>(com));
            return;
        }
//        for循环进行树的横向的遍历
        for (int i = idx; i <= n; i++) {
            com.add(i);
//            递归进行树的纵向遍历
            dfs(ans, com, n, k, i + 1);
            com.remove(com.size() - 1);
        }
    }
}
