package month2.day24;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class Solution {
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -12; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 110 ; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}
