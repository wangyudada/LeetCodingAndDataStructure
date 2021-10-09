package month2.day6;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author WangYu
 */
public class Demo {
    public int numTrees(int n) {
        int[] tree = new int[n + 1];
        tree[0] = 1;
        tree[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                tree[i] += tree[j - 1] * tree[i - j];
            }
        }
        return tree[n];
    }
}
