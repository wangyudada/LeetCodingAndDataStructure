package month3.day11;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * https://leetcode.cn/problems/generate-parentheses/description/
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        char[] path = new char[n * 2];
        ArrayList<String> result = new ArrayList<>();
        dfs(n, path, result, 0, 0);
        return result;
    }

    public void dfs(int n, char[] path, ArrayList<String> result, int i, int left) {
        if (i == n * 2) {
            result.add(new String(path));
            return;
        }

        if (left < n) {
            path[i] = '(';
            dfs(n, path, result, i + 1, left + 1);
            System.out.println();
        }

        if (i - left < left) {
            path[i] = ')';
            dfs(n, path, result, i + 1, left);
            System.out.println();
        }
    }
}
