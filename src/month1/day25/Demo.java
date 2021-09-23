package month1.day25;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 示例
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * @author WangYu
 */
public class Demo {
    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(chars, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        int high = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[high][width];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                boolean flag = dfs(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int idx) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = dir[0] + i;
            int newj = dir[1] + j;
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = dfs(board, visited, newi, newj, word, idx + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
