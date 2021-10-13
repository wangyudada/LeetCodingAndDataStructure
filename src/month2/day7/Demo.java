package month2.day7;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author WangYu
 */
public class Demo {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> dfs = dfs(1, n);
        return dfs;
    }

    public List<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (start >= end) {
            treeNodes.add(start == end ? new TreeNode(start) : null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = dfs(start, i - 1);
                List<TreeNode> right = dfs(i + 1, end);
                for (TreeNode treeNode : left) {
                    for (TreeNode node : right) {
                        treeNodes.add(new TreeNode(i, treeNode, node));
                    }
                }
            }
        }
        return treeNodes;
    }
}
