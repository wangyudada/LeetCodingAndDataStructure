package month2.day25;

import java.util.ArrayList;

public class Solution {
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] vo = new int[n];
        for (int i = 0, idx = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            vo[i] = i - idx;
        }
        for (int i = n - 1, idx = 2 * n; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            vo[i] = Math.min(vo[i], idx - i);
        }
        return vo;
    }
}
