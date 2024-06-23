package month3.day24;

import java.util.HashSet;

public class Solution {
    /**
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int right = 0;
        HashSet<Character> path = new HashSet<>();
        for (int left = 0; left < length; left++) {
            if (left != 0) {
                path.remove(s.charAt(left - 1));
            }

            while (right < length && !path.contains(s.charAt(right))) {
                path.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, path.size());
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/spiral-matrix-ii/description/
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int loop = 1;
        int i, j;
        while (loop <= n / 2) {
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            for (; i > startX; i--) {
                nums[i][j] = count++;
            }

            startY++;
            startX++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}