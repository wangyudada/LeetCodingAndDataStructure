package month1.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (char[] c : selected) {
            Arrays.fill(c, '.');
        }
        dfs(n, 0, ans, selected);
        return ans;
    }

    public static void dfs(int n, int row, List<List<String>> ans, char[][] selected) {
//        如果行已经到了N行（根据题意，这是一个正方形数独），则说明递归的遍历结束
        if (row == n) {
            ans.add(toList(selected));
            return;
        }
//        for循环是对每一层（左右向）的遍历
        for (int i = 0; i < n; i++) {
            if (isValid(n, row, i, selected)) {
                selected[row][i] = 'Q';
                dfs(n, row + 1, ans, selected);
                selected[row][i] = '.';
            }
        }
    }

    /**
     * 判断是否能放入皇后Q，由于每一层都不会取到一样的数据，所以同一层是不用判断的
     *
     * @param n        n个皇后，也可以解释成数独的长和宽
     * @param row      行数
     * @param i        列数
     * @param selected 已经被存入的数独数组
     * @return
     */
    private static boolean isValid(int n, int row, int i, char[][] selected) {
        for (int j = 0; j < row; j++) {
//            二维数组的第二个参数是代表的列，所以这边先排除列有等于Q的情况
            if (selected[j][i] == 'Q') {
                return false;
            }
        }
//        下面排除两个斜对角是Q的情况
//        这边是判断45度
        for (int j = row - 1, k = i - 1; j >= 0 && k >= 0; j--, k--) {
            if (selected[j][k] == 'Q') {
                return false;
            }
        }
//        这边是判断135度
        for (int j = row - 1, k = i + 1; j >= 0 && k < n; j--, k++) {
            if (selected[j][k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //    二维数组转换成特定的字符串数组
    private static List<String> toList(char[][] selected) {
        ArrayList<String> res = new ArrayList<>();
        for (char[] chars : selected) {
            res.add(String.copyValueOf(chars));
        }
        return res;
    }
}
