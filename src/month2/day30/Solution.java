package month2.day30;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] heights;
    int high, width;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.high = heights.length;
        this.width = heights[0].length;
        boolean[][] pacific = new boolean[high][width];
        boolean[][] atlantic = new boolean[high][width];
        for (int i = 0; i < high; i++) {
            dfs(i, 0, pacific);
        }
        for (int i = 1; i < width; i++) {
            dfs(0, i, pacific);
        }
        for (int i = 0; i < high; i++) {
            dfs(i, width - 1, atlantic);
        }
        for (int i = 0; i < width - 1; i++) {
            dfs(high - 1, i, atlantic);
        }
        ArrayList<List<Integer>> vos = new ArrayList<>();
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> vo = new ArrayList<>();
                    vo.add(i);
                    vo.add(j);
                    vos.add(vo);
                }
            }
        }
        return vos;
    }

    public void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            if (newRow < high && newRow >= 0 && newCol < width && newCol >= 0 && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }
}
