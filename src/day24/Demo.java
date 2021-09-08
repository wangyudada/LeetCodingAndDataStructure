package day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
 * 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
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
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        dfs(n, 0, ans, chars);
        return ans;
    }

    public static void dfs(int n, int row, List<List<String>> ans, char[][] chars) {
        if (row == n) {
            ans.add(char2List(chars));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValiad(n, row, i, chars)) {
                chars[row][i] = 'Q';
                dfs(n, row + 1, ans, chars);
                chars[row][i] = '.';
            }
        }
    }

    private static boolean isValiad(int n, int row, int i, char[][] chars) {
        for (int j = 0; j < row; j++) {
//            二维数组的第二个参数是代表的列，所以这边先排除列有等于Q的情况
            if (chars[j][i] == 'Q') {
                return false;
            }
        }
//        下面排除两个斜对角是Q的情况
//        这边是判断45度
        for (int j = row - 1, k = i - 1; j >= 0 && k >= 0; j--, k--) {
            if (chars[j][k] == 'Q') {
                return false;
            }
        }
//        这边是判断135度
        for (int j = row - 1, k = i + 1; j >= 0 && k < n; j--, k++) {
            if (chars[j][k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<String> char2List(char[][] chars) {
        ArrayList<String> strings = new ArrayList<>();
        for (char[] aChar : chars) {
            strings.add(String.copyValueOf(aChar));
        }
        return strings;
    }
}
