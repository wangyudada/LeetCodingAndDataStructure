package day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author WangYu
 */
public class Demo {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }

    public static List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> ans = new ArrayList<>();
        char[][] selected = new char[n][n];
        return ans;
    }

    public static void dfs(int n, int row, List<List<String>> ans, char[][] selected) {
        if (row == n) {
            ans.add(toList(selected));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(n, row, i, selected)) {
                selected[row][i] = 'Q';
                dfs(n, row + 1, ans, selected);
                selected[row][i] = '.';
            }
        }
    }

    private static boolean isValid(int n, int row, int i, char[][] selected) {
        
    }

    private static List<String> toList(char[][] selected) {

    }

}
