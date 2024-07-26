package month4.day8;

public class Solution {
    /**
     * https://leetcode.cn/problems/valid-sudoku/description/
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] nine = new int[3][3][9];
        int width = board.length;
        int high = board[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < high; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    nine[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[i][index] > 1 || nine[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
