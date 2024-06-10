package month3.day19;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result;

    List<Integer> tmp;

    /**
     * https://leetcode.cn/problems/combinations/description/
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(1, n, k);
        return result;
    }

    private void dfs(int index, int n, int k) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i <= n; i++) {
            tmp.add(i);
            dfs(i + 1, n, k);
            tmp.remove(tmp.size() - 1);
        }
    }
}
