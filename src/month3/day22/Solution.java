package month3.day22;

import month2.day7.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result;

    List<Integer> tmp;

    /**
     * https://leetcode.cn/problems/path-sum-ii/submissions/540693945/
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(root, targetSum, tmp);
        return result;
    }

    public void dfs(TreeNode node, int sum, List<Integer> path) {
        if (node == null) {
            return;
        }

        if (node.val == sum && node.left == null && node.right == null) {
            path.add(node.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(node.val);
        dfs(node.left, sum - node.val, path);
        dfs(node.right, sum - node.val, path);
        path.remove(path.size() - 1);
    }
}
